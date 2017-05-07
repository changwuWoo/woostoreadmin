package org.edge.woostore.web.api.impl;

import org.edge.woostore.core.service.IGroupService;
import org.edge.woostore.core.service.impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/25.
 */
@RestController
@RequestMapping
public class FunctionControler {
    @Autowired
    @Qualifier(value = "groupService")
    private GroupService groupService;
    public Map getPhotoList(){
        return null;
    }
    public Map getPhotoItemByPkId(){
        return null;
    }
    public Map updatePhotoByPkID(){
        return null;
    }
    public Map movePhotoItem(){
        return null;
    }
    public Map movePhotoItems(){
        return null;
    }
    public Map copyPhotoItem(){
        return null;
    }
    public Map copyPhotoItems(){
        return null;
    }
    public Map deletePhotoItem(){
        return null;
    }
    public Map deletePhotoItems(){
        return null;
    }
    @RequestMapping(value = "get",method = RequestMethod.POST)
    public Map getMenuItemById(@Valid String pkid){
        Map reMap =new HashMap();
        if(null!=pkid&&!"".equals(pkid)){
        }
        return null;
    }
    public Map updateMenuItemById(){
        return null;
    }
    public Map updateMenuItemsById(){
        return null;
    }
    public Map getRoleList(){
        return null;
    }
    public Map getRoleItemById(){
        return null;
    }
    public Map updateRoleItemById(){
        return null;
    }

    public Map updateRoleItems(){
        return null;
    }
    @RequestMapping(value = "getMenuList",method = RequestMethod.POST)
    public Map getGroupChildList(@RequestHeader String pkId){

        return null;
    }
}
