package org.edge.woostore.core.service;

import org.edge.woostore.domain.entity.Group;

import java.util.Collection;

/**
 * Created by Administrator on 2017/7/4.
 */
public interface IGroupService extends ICoreService<Group>{
    Collection<Group> queryListByPkId(String pkId);
    Collection<Group> queryGroupList();
    boolean updateGroup(Group group);
    boolean insertGroup(Group group);
}
