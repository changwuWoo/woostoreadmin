package org.woo.core.service;



import org.woo.domain.entity.Permission;
import org.woo.domain.repository.Page;

import java.util.Collection;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface IPermissionService extends ICoreService<Permission>{
    Collection<Permission> getPermissions();
    Page<Permission> getListByPage(int pageSize, int page, String filter);
    boolean updatePermission(Permission permission);
    boolean insertPermission(Permission permission);
}
