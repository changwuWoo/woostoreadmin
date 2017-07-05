package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Role;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.IRoleDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/28.
 */
@Repository
public class RoleDao extends AbstractCoreDao<Role,String> implements IRoleDao {

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
    public int batchInsert(List<Role> records) {
        return 0;
    }

    @Override
    public int insertSelective(Role record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return 0;
    }

}
