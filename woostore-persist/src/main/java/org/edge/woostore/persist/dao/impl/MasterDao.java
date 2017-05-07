package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Master;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.IMasterDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
@Repository(value = "masterDao")
public class MasterDao extends AbstractCoreDao<Master,String> implements IMasterDao{
    @Override
    public int deleteByPrimaryKey(String pkId) {
        return 0;
    }

    @Override
    public boolean insert(Master record) {
        return false;
    }

    @Override
    public int insertSelective(Master record) {
        return 0;
    }

    @Override
    public Master selectByPrimaryKey(String pkId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Master record) {
        return 0;
    }

    @Override
    public boolean updateByPrimaryKey(Master record) {
        return false;
    }

    @Override
    public Master selectByName(String name) {
        return null;
    }

    @Override
    public boolean insert(List<Master> list) {
        return false;
    }

    @Override
    public boolean isExistByUsername(String name) {
        String hql = "from Master admin where lower(admin.username) = lower(?)";
        Master admin = (Master) getSession().createQuery(hql).setParameter(0, name).uniqueResult();
        if (admin != null) {
            return true;
        } else {
            return false;
        }
    }
}
