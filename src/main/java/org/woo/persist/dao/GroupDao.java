package org.woo.persist.dao;

import org.woo.domain.entity.Group;
import org.woo.persist.dao.AbstractCoreDao;
import org.woo.persist.dao.IGroupDao;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/20.
 */
@Repository
public class GroupDao extends AbstractCoreDao<Group,String> implements IGroupDao {


    @Override
    public boolean isExistByName(String hql, Map<String,Object> map) {
        return false;
    }

    @Override
    public int deleteByPrimaryKey(List<String> pkIds) {
        return 0;
    }

    @Override
    public int batchInsert(List<Group> records) {
        return 0;
    }


    @Override
    public int insertSelective(Group record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Group record) {
        return 0;
    }

    @Override
    public Collection<Group> getRootNode(String hql, Map<String,Object> map) {
        return null;
    }

    @Override
    public Collection<Group> getChildNode(String hql, Map<String,Object> map) {
        return null;
    }

    @Override
    public Boolean isRootNode(String hql, Map<String,Object> map) {
        return null;
    }
}
