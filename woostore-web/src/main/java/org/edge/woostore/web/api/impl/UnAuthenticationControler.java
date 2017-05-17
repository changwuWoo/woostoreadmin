package org.edge.woostore.web.api.impl;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.edge.woostore.core.service.IAuthenticationService;
import org.edge.woostore.core.service.ITokenService;
import org.edge.woostore.core.service.IUserService;
import org.edge.woostore.domain.dto.ResultDTO;
import org.edge.woostore.domain.entity.Master;
import org.edge.woostore.domain.entity.Token;
import org.edge.woostore.utils.constant.Constants;
import org.edge.woostore.utils.util.JwtUtil;
import org.edge.woostore.web.api.AbstractControler;
import org.edge.woostore.web.api.IControler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: @UnAuthenticationControler
 * @author Administrator 
 * @date 2017年3月1日 下午6:08:05 
 *  
 */
@RequestMapping("ua")
@RestController
public class UnAuthenticationControler extends AbstractControler implements IControler{
	 private Log logger = LogFactory.getLog(UnAuthenticationControler.class);
    @Qualifier("authenticationServiceImpl")
    @Autowired
    private IAuthenticationService authenticationServiceImpl;
    @Qualifier("userService")
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ITokenService iTokenService;
    @Autowired
    private JwtUtil jwt;
    /** 
    * @Title: loginRequest 
    * @Description: TODO
    * @param @return
    * @return Map<String,Object>
    * @throws
    * @time 2017年3月8日上午10:59:17
    */
    @RequestMapping(value="/loginRequest",method= RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> loginRequest() {
    	Map<String, Object> reMap = new HashMap<String, Object>();
        reMap.put("code", 200);
        logger.info("当前数值" + reMap);
        return reMap;
    }
    
    /** 
    * @Title: indexRequest
    * @Description: 对首页进行定制，推广一些东西
    * @param @return
    * @return Map<String,Object>
    * @throws 
    * @time 2017年3月8日下午12:05:47
    */
    @RequestMapping(value="/indexRequest",method=RequestMethod.POST)
    public @ResponseBody Map<String, Object> indexRequest(){
    	Map<String, Object> reMap=new HashMap<String, Object>();
    	reMap.put("code", 200);
    	return reMap;
    }

    /** 
    * @Title: userLogin 
    * @Description: TODO
    * @param @return
    * @return Map<String,Object>
    * @throws 
    * @time 2017年3月8日上午10:59:12
    */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public  @ResponseBody Map<String, Object> userLogin(
            @Valid @RequestBody Master master,
            BindingResult bindingResult) throws Exception {
        Map<String, Object> reMap = new HashMap<String, Object>();
        List<ObjectError> errorList = bindingResult.getAllErrors();
        for(ObjectError error : errorList){
            System.out.println(error.getDefaultMessage());
        }
        ResultDTO resultDTO=null;
        if (bindingResult.hasErrors()) {
            reMap.put("errorMsg", bindingResult.getFieldError().getDefaultMessage());
        }
        Master remaster=null;
        remaster=iUserService.getUserByUserName(master.getFname());
        if(remaster!=null&&master.getFname().equalsIgnoreCase(remaster.getFname())){
            if(master.getFpassword().equals(remaster.getFpassword())){
                reMap.put("result", new ResultDTO().success(ResultDTO.LOGIN_SUCCESS,ResultDTO.RESCODE_SUCCESS));
                //修改登录逻辑变化，如果用户名和用户信息验证通过直接替换掉服务器端保存的IP和token字符串
                String subject = JwtUtil.generalSubject(remaster);

                String token = jwt.createJWT(Constants.JWT_ID, subject, Constants.JWT_TTL);
                String refreshToken = jwt.createJWT(Constants.JWT_ID, subject, Constants.JWT_REFRESH_TTL);
                JSONObject jo = new JSONObject();
                jo.put("token", token);
                jo.put("refreshToken", refreshToken);
                System.out.println(token.length());
                reMap.put("token",token);
            }else{
                reMap.put("result", new ResultDTO().failure(ResultDTO.LOGIN_FAILD,ResultDTO.RESCODE_EXCEPTION));
            }
        }else{
            reMap.put("result", new ResultDTO().failure(ResultDTO.NO_THIS_USEERNAME,ResultDTO.RESCODE_EXCEPTION));
        }
        logger.info("" + reMap);
        return reMap;
    }
    @RequestMapping(value = "/tokenLogin",method = RequestMethod.POST)
    public @ResponseBody Map<String,String> tokenLogin(@Valid @RequestParam  String token,BindingResult bindingResult) throws Exception {
        Map<String,String> reMap=new HashMap<String,String>();
        List<ObjectError> errorList = bindingResult.getAllErrors();
        for(ObjectError error : errorList){
            System.out.println(error.getDefaultMessage());
        }
        Token serverToken=null;
        String ip=super.getIpV4();     //获取当前回话的发起请求的IP
        if (token!=null&&!"".equals(token)){
            serverToken=iTokenService.getTokenByAccessToken(token);
            if (serverToken!=null&&ip.equals(serverToken.getIp())){  //如果IP受信任，那么可以就绪下一步验证其他得信息
                /*
                * 对于IP已经验证通过的IP，然后验证token里面的信息，主要是对token的有效期进行验证,
                * 然后根据有效期的判断结果返回相应的数据结果
                * */
                Claims claims = jwt.parseJWT(token);   //解析token结构
                String json = claims.getSubject();
                Master master = JSONObject.parseObject(json, Master.class);  //解析出数据信息
                String subject = JwtUtil.generalSubject(master);
                String refreshToken = jwt.createJWT(Constants.JWT_ID, subject, Constants.JWT_TTL);
                reMap.put("refreshToken",refreshToken);
            }else{
                reMap.put("tokenip","您当前环境不受信任，请输入用户信息"); //IP不受信任，直接返回验证失败的结果并且要求验证用户名信息
            }
        }else{
            reMap.put("tokenmes","token无效");
        }
        return reMap;
    }
    /** 
    * @Title: registerRequest 
    * @Description: TODO
    * @param @return
    * @return Map<String,Object>
    * @throws 
    * @time 2017年3月8日上午10:59:08
    */
    @ResponseBody
    @RequestMapping(value="/registerRequest.do",method=RequestMethod.POST)
    public Map<String, Object> registerRequest(){
    	Map<String, Object> reMap = new HashMap<String, Object>();
        reMap.put("code", 200);
        logger.info("" + reMap);
        return reMap;
    }
    /**
     * @Title: passowrd
     * @Description: 先验证用户名是否存在，如果不存在则不需要走找密码流程
    * @param 
    * @return void
    * @throws 
    * @time 2017年3月8日上午10:55:57
    */
    @ResponseBody
    @RequestMapping(value="/password.do",method=RequestMethod.POST)
    public void passowrd(String userName){
    }
}
