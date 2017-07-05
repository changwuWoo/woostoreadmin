package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Permission;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.IPermissionDao;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/19.
 */
@Repository
public class PermissionDao extends AbstractCoreDao<Permission,String> implements IPermissionDao {
    @Override
    public boolean isExistByName(String hql, Map map) {
        return false;
    }

    @Override
    public int deleteByPrimaryKey(String hql, Map map) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(List<String> pkIds) {
        return 0;
    }


    @Override
    public int batchInsert(List<Permission> records) {
        return 0;
    }

    @Override
    public int insertSelective(Permission record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return 0;
    }


    @Override
    public Collection<Permission> selectListByPrivilegeMaster(String sql,Map map) {
        Collection<Permission> privilegeCollection = sqlQueryBuilder(sql,map).list();
        return privilegeCollection;
    }
}
