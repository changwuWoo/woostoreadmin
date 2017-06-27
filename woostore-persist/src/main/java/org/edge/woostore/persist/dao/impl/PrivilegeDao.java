package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Privilege;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.IPrivilegeDao;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/29.
 */
@Repository
public class PrivilegeDao extends AbstractCoreDao<Privilege,String> implements IPrivilegeDao {

    @Override
    public boolean isExistByname(String hql, Map map) {
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
    public int batchinsert(List<Privilege> records) {
        return 0;
    }

    @Override
    public int insertSelective(Privilege record) {
        return 0;
    }


    @Override
    public int updateByPrimaryKeySelective(Privilege record) {
        return 0;
    }
}
