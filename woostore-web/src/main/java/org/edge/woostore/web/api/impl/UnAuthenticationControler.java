package org.edge.woostore.web.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.edge.woostore.core.service.IAuthenticationService;
import org.edge.woostore.core.service.ITokenService;
import org.edge.woostore.core.service.IUserService;
import org.edge.woostore.domain.dto.ResultDTO;
import org.edge.woostore.domain.entity.Master;
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
    @Qualifier("userServiceimpl")
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ITokenService iTokenService;
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
            @Valid @RequestParam(value = "name") String name,
            @Valid @RequestParam(value = "password") String pawword,
            BindingResult bindingResult) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        List<ObjectError> errorList = bindingResult.getAllErrors();
        for(ObjectError error : errorList){
            System.out.println(error.getDefaultMessage());
        }
        ResultDTO resultDTO=null;
        if (bindingResult.hasErrors()) {
            reMap.put("errorMsg", bindingResult.getFieldError().getDefaultMessage());
        }
        Master master=null;
        logger.debug(master);
        master=iUserService.getUserByUserName(name);
        if(master!=null&&master.getFname().equalsIgnoreCase(master.getFname())){
            if(pawword.equals(master.getFpassword())){
                reMap.put("result", new ResultDTO().success(ResultDTO.LOGIN_SUCCESS));
                reMap.put("token",authenticationServiceImpl.authenticate(master.getFname()));
            }else{
                reMap.put("result", new ResultDTO().failure(ResultDTO.LOGIN_FAILD));
            }
        }else{
            reMap.put("result", new ResultDTO().failure(ResultDTO.NO_THIS_USEERNAME));
        }
        logger.info("" + reMap);
        return reMap;

        /*
            System.out.println(name+"-----"+password);

            *//**

         * 判断是否登录成功

         * 1.登录成功

         *  1.1.成功生成对应的token并更新

         *  1.2.失败就抛异常

         *//*

            String token=tokenMap.get(name);

            UserInfo user=null;

            if(token==null){

                user=new UserInfo();

                user.setFname(name);

                user.setFpasswd(password);

                System.out.println("新用户登录");

            }else{

                user=loginUserMap.get(token);

                loginUserMap.remove(token);

                System.out.println("更新用户登录token");

            }

            token= MD5Method.MD5(name + password + new Date().getTime());

            loginUserMap.put(token, user);

            tokenMap.put(name, token);

            System.out.println("目前有"+tokenMap.size()+"个用户");

            for(UserInfo u:loginUserMap.values()){

                System.out.println(u.getFname()+":"+u.getFpasswd());

            }

            return token;*/
    }
    @RequestMapping(value = "/tokenLogin",method = RequestMethod.POST)
    public Map tokenLogin(@Valid @RequestParam  String token,BindingResult bindingResult){
        Map<String,String> reMap=null;
        List<ObjectError> errorList = bindingResult.getAllErrors();
        for(ObjectError error : errorList){
            System.out.println(error.getDefaultMessage());
        }
        super.getIpV4();
        if (token!=null&&!"".equals(token)){

        }else{

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
