package org.woo.persist.dao;

import org.woo.domain.entity.Group;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/20.
 */
public interface IGroupDao extends ICoreDao<Group,String>{
    @Transactional
    Collection<Group> getRootNode(String hql, Map<String,Object> map);
    @Transactional
    Collection<Group> getChildNode(String hql, Map<String,Object> map);
    @Transactional
    Boolean isRootNode(String hql, Map<String,Object> map);
}
