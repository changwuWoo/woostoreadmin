package org.edge.woostore.web.api.impl;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.edge.woostore.core.service.IAuthenticationService;
import org.edge.woostore.core.service.ITokenHistoryService;
import org.edge.woostore.core.service.IMasterService;
import org.edge.woostore.core.service.ITokenService;
import org.edge.woostore.domain.entity.Master;
import org.edge.woostore.domain.entity.TokenHistory;
import org.edge.woostore.utils.constant.Constants;
import org.edge.woostore.utils.util.JwtUtil;
import org.edge.woostore.web.api.AbstractController;
import org.edge.woostore.web.api.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @ClassName: @UnAuthenticationController
 * @date 2017年3月1日 下午6:08:05
 */
@RequestMapping("ua")
@RestController
public class UnAuthenticationController extends AbstractController implements IController {
    private Log logger = LogFactory.getLog(UnAuthenticationController.class);
    @Qualifier("authenticationServiceImpl")
    @Autowired
    private IAuthenticationService authenticationServiceImpl;
    @Autowired
    private IMasterService iMasterService;
    @Autowired
    private ITokenHistoryService iTokenHistoryService;
    @Autowired
    private JwtUtil jwt;
    @Autowired
    private ITokenService iTokenService;

    /**
     * @param @return
     * @return Map<String,Object>
     * @throws
     * @Title: loginRequest
     * @Description: TODO
     * @time 2017年3月8日上午10:59:17
     */
    @RequestMapping(value = "/loginRequest", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> loginRequest() {
        Map<String, Object> reMap = new HashMap<String, Object>();
        reMap.put("code", 200);
        logger.info("当前数值" + reMap);
        return reMap;
    }

    /**
     * @param @return
     * @return Map<String,Object>
     * @throws
     * @Title: indexRequest
     * @Description: 对首页进行定制，推广一些东西
     * @time 2017年3月8日下午12:05:47
     */
    @RequestMapping(value = "/indexRequest", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> indexRequest() {
        Map<String, Object> reMap = new HashMap<String, Object>();
        reMap.put("code", 200);
        return reMap;
    }

    /**
     * @param @return
     * @return Map<String,Object>
     * @throws
     * @Title: userLogin
     * @Description: TODO
     * @time 2017年3月8日上午10:59:12
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> userLogin(
            @Valid @RequestBody Master master,
            BindingResult bindingResult) throws Exception {
        Map<String, Object> reMap = new HashMap<String, Object>();
        List<ObjectError> errorList = bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            for (ObjectError error : errorList) {
                System.out.println(error.getDefaultMessage());
                error.getObjectName();
            }
            reMap.put(KEY_MSG, bindingResult.getFieldError().getDefaultMessage());
        }
        Master reMaster = null;
        TokenHistory serverTokenHistory = new TokenHistory();
        reMaster = iMasterService.queryByUserName(master.getFname());
        if (reMaster != null && master.getFname().equalsIgnoreCase(reMaster.getFname())) {
            if (master.getFpasswd().equals(reMaster.getFpasswd())) {
                reMap.put(KEY_CODE, RESCODE_SUCCESS);
                reMap.put(KEY_DATA, reMaster);
                reMap.put(KEY_MSG, LOGIN_SUCCESS);
                //修改登录逻辑变化，如果用户名和用户信息验证通过直接替换掉服务器端保存的IP和loginTokenHistory字符串
                Map map = new HashMap();
                map.put("pkId", reMaster.getPkId());
                String subject = JwtUtil.generalSubject(map);
                String loginTokenHistory = jwt.createJWT(Constants.JWT_ID, subject, Constants.JWT_TTL);
                if (iTokenService.updateToken(reMaster.getPkId(), loginTokenHistory)) {
                    serverTokenHistory.setPkId(iTokenHistoryService.getSeq());
                    serverTokenHistory.setFip(super.getIpV4());
                    serverTokenHistory.setFaccesstoken(loginTokenHistory);
                    serverTokenHistory.setFkMasterId(reMaster.getPkId());
                    iTokenHistoryService.insert(serverTokenHistory);
                }
                reMap.put(KEY_AUTH, loginTokenHistory);
            } else {
                reMap.put(KEY_CODE, RESCODE_NOEXIST);
                reMap.put(KEY_MSG, LOGIN_FAILD);
            }
        } else {
            reMap.put(KEY_CODE, RESCODE_NOEXIST);
            reMap.put(KEY_MSG, LOGIN_USEERNAMENOTEXIT);
        }
        logger.info("" + reMap);
        return reMap;
    }

    @RequestMapping(value = "/tokenLogin", method = RequestMethod.GET)
    public
    @ResponseBody
    Map loginTokenLogin(@RequestParam(value = "authorization") String loginTokenHistory,
                        HttpServletRequest httpRequest) {
        Map reMap = new HashMap<>();
        TokenHistory serverTokenHistory = new TokenHistory();
        Claims claims = null;   //解析loginTokenHistory结构
        String refushToken = null;
        try {
            claims = jwt.parseJWT(loginTokenHistory);//解析loginTokenHistory结构
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            reMap.put(KEY_EXCEPTION, e.getMessage());
            reMap.put(KEY_CODE, RESCODE_EXCEPTION);
            reMap.put(KEY_MSG, AUTH_FAILD_EXP);
            return reMap;
        }
        if (claims != null) {
            String json = claims.getSubject();
            Master master = JSONObject.parseObject(json, Master.class);
            String accessToken = (String) iTokenService.getTokenByMaterId(master.getPkId());
            TokenHistory tokenHistory = null;
            tokenHistory = iTokenHistoryService.getTokenByAccessToken(accessToken);
            if (loginTokenHistory.equals(accessToken)) {
                if (tokenHistory != null && tokenHistory.getFip() != null && tokenHistory.getFip().length() > 0 && super.getIpV4().equals(tokenHistory.getFip())) {
                    Map map = new HashMap();
                    map.put("pkId", master.getPkId());
                    String subject = JwtUtil.generalSubject(map);
                    try {
                        refushToken = jwt.createJWT(Constants.JWT_ID, subject, Constants.JWT_TTL);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (iTokenService.updateToken(master.getPkId(), refushToken)) {
                        serverTokenHistory.setPkId(iTokenHistoryService.getSeq());
                        serverTokenHistory.setFkMasterId(master.getPkId());
                        serverTokenHistory.setFip(super.getIpV4());
                        serverTokenHistory.setFaccesstoken(refushToken);
                        iTokenHistoryService.insert(serverTokenHistory);
                    }
                    reMap.put(KEY_CODE, RESCODE_SUCCESS);
                    reMap.put(KEY_AUTH, refushToken);
                    reMap.put(KEY_MSG, AUTH_SUCCESS_MSG);
                } else {
                    reMap.put(KEY_CODE,RESCODE_FAILD);
                    reMap.put(KEY_MSG,AUTH_FAILD_IP);
                }
            } else {
                reMap.put(KEY_CODE,RESCODE_FAILD);
                reMap.put(KEY_MSG,LOGIN_OTHERDEC);
            }
        }
        return reMap;
    }

    /**
     * @param @return
     * @return Map<String,Object>
     * @throws
     * @Title: registerRequest
     * @Description: TODO
     * @time 2017年3月8日上午10:59:08
     */
    @ResponseBody
    @RequestMapping(value = "/registerRequest", method = RequestMethod.POST)
    public Map<String, Object> registerRequest() {
        Map<String, Object> reMap = new HashMap<String, Object>();
        reMap.put("code", 200);
        logger.info("" + reMap);
        return reMap;
    }

    /**
     * @param
     * @return void
     * @throws
     * @Description: 先验证用户名是否存在，如果不存在则不需要走找密码流程
     * @time 2017年3月8日上午10:55:57
     */
    @ResponseBody
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public void modifyPassWord(String userName) {
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public Map loginOut() {
        return null;
    }
}
