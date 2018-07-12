package org.woo.web.controller;


import org.woo.core.service.IMasterService;
import org.woo.domain.annotation.AccessTokenValidate;
import org.woo.domain.entity.Master;
import org.woo.domain.repository.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/4/6.
 */
@Controller
@RequestMapping("auth")
public class UserController extends AbstractController<Master> {
    @Autowired
    private IMasterService userService;
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    @AccessTokenValidate
    public @ResponseBody
    Map<String,Object> getUserList(@RequestParam(value = "pageSize",required = false) @Valid String pageSize,
                    @RequestParam(value = "currentPage",required = false)String currentPage){
        int ps=Integer.parseInt(pageSize);
        int cp=Integer.parseInt(currentPage);
        Page<Master> masterPage=userService.getListByPage(ps,cp,new Master());
        return super.resultPageUtil(masterPage);
    }
    @AccessTokenValidate
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getUser(@RequestParam(value = "pkId") String pkId){
        Map<String,Object> reMap =new HashMap<String,Object>();
        if (pkId!=null&&!"".equals(pkId.trim())){
            reMap=super.resultEUtil(userService.getEntityByPkId(pkId));
        }else{
            reMap.put(KEY_CODE,RESCODE_FAILD);
            reMap.put(KEY_MSG,RESDATA_REQERR);
        }
        return reMap;
    }
    @AccessTokenValidate
    @RequestMapping(value = "/updateUsrInfo")
    public @ResponseBody Map<String,Object> updateUserInfo(@RequestBody @Valid Master master, BindingResult bindingResult){
        Map<String,Object> reMap = new HashMap<String,Object>();
        if (bindingResult.hasErrors()) {
            reMap.put("errorMsg", bindingResult.getFieldError().getDefaultMessage());
        }
        return null;
    }
}
