package org.woo.persist.dao;

import org.woo.domain.entity.Permission;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface IPermissionDao extends ICoreDao<Permission,String>{
    @Transactional
    Collection<Permission> selectListByPrivilegeMaster(String sql, Map<String,Object> map);
}
