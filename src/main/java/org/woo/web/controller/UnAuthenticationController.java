package org.woo.web.controller;

import io.jsonwebtoken.Claims;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.woo.core.service.IMasterService;
import org.woo.core.service.ITokenHistoryService;
import org.woo.core.service.ITokenService;
import org.woo.domain.entity.Master;
import org.woo.domain.entity.TokenHistory;
import org.woo.utils.constant.Constants;
import org.woo.utils.util.JwtUtil;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Administrator
 * @ClassName: @UnAuthenticationController
 * @date 2017年3月1日 下午6:08:05
 */
@RequestMapping("ua")
@RestController
public class UnAuthenticationController extends AbstractController<Master> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private IMasterService iMasterService;
    private ITokenHistoryService iTokenHistoryService;
    private JwtUtil jwt = new JwtUtil();
    private ITokenService iTokenService;

    /**
     * @param @return
     * @return Map<String,Object>
     * @throws
     * @Title: loginRequest
     * @Description: TODO  
     * @time 2017年3月8日上午10:59:17
     */
    @RequestMapping(value = "/loginRequest.do", method = RequestMethod.GET)
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
    @RequestMapping(value = "/indexRequest.do", method = RequestMethod.POST)
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
    @RequestMapping(value = "/userLogin.do", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> userLogin(
            @RequestBody Master master,
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
        reMaster = iMasterService.queryByUserName(master.getLoginName());
        if (reMaster != null && master.getLoginName().equalsIgnoreCase(reMaster.getLoginName())) {
            if (master.getLoginPassWord().equals(reMaster.getLoginPassWord())) {
                reMap.put(KEY_CODE, RESCODE_SUCCESS);
                reMap.put(KEY_DATA, reMaster);
                reMap.put(KEY_MSG, LOGIN_SUCCESS);
                //修改登录逻辑变化，如果用户名和用户信息验证通过直接替换掉服务器端保存的IP和loginTokenHistory字符串
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("pkId", reMaster.getPkId());
                String subject = JwtUtil.generalSubject(map);
                String loginTokenHistory = jwt.createJWT(Constants.JWT_ID, subject, Constants.JWT_TTL);
                if (iTokenService.updateToken(reMaster.getPkId(), loginTokenHistory)) {
                    serverTokenHistory.setPkId(iTokenHistoryService.getSeq());
                    serverTokenHistory.setLoginIp(super.getIpV4());
                    serverTokenHistory.setAccessToken(loginTokenHistory);
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

    @RequestMapping(value = "/tokenLogin.do", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> loginTokenLogin(@RequestParam(value = "authorization") String loginTokenHistory,
                                        HttpServletRequest httpRequest) {
        Map<String, Object> reMap = new HashMap<String, Object>();
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
                if (tokenHistory != null && tokenHistory.getLoginIp() != null && tokenHistory.getLoginIp().length() > 0 && super.getIpV4().equals(tokenHistory.getLoginIp())) {
                    Map<String, Object> map = new HashMap<String, Object>();
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
                        serverTokenHistory.setLoginIp(super.getIpV4());
                        serverTokenHistory.setAccessToken(refushToken);
                        iTokenHistoryService.insert(serverTokenHistory);
                    }
                    reMap.put(KEY_CODE, RESCODE_SUCCESS);
                    reMap.put(KEY_AUTH, refushToken);
                    reMap.put(KEY_MSG, AUTH_SUCCESS_MSG);
                } else {
                    reMap.put(KEY_CODE, RESCODE_FAILD);
                    reMap.put(KEY_MSG, AUTH_FAILD_IP);
                }
            } else {
                reMap.put(KEY_CODE, RESCODE_FAILD);
                reMap.put(KEY_MSG, LOGIN_OTHERDEC);
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
    @RequestMapping(value = "/registerRequest.do", method = RequestMethod.POST)
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
    @RequestMapping(value = "/password.do", method = RequestMethod.POST)
    public void modifyPassWord(String userName) {
    }

    @RequestMapping(value = "/loginOut.do", method = RequestMethod.GET)
    public Map<String, Object> loginOut() {
        return null;
    }
}
