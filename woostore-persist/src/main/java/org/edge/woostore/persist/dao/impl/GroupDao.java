package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Group;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.IGroupDao;
import org.hibernate.Query;
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
    public boolean isExistByName(String hql, Map map) {
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
    public Collection<Group> getRootNode() {
        String hql="from Group group where group.parentId = null ";
        Collection<Group> groupCollection=getSession().createQuery(hql).list();
        return groupCollection;
    }

    @Override
    public Collection<Group> getChildNode(String pkId) {
        String hql="from Group group where group.parentId = ? ";
        Collection<Group> groupCollection=getSession().createQuery(hql).setParameter(0, pkId).list();
        return groupCollection;
    }

    @Override
    public Boolean isRootNode(String pkId) {
        String hql="from Group group where group.pkId = ? ";
        Collection<Group> groupCollection=getSession().createQuery(hql).setParameter(0, pkId).list();
        return groupCollection.size()==1?true:false;
    }
}
