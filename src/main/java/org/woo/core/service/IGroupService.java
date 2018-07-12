package org.woo.core.service;

import org.woo.domain.entity.Group;

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
