package org.woo.core.service;



import org.woo.domain.entity.Role;

import java.util.Collection;

/**
 * Created by Administrator on 2017/5/30.
 */
public interface IRoleService extends ICoreService<Role>{
    Collection<Role> getRoles();
    boolean updateRole(Role role);
    boolean insertRole(Role role);
}
