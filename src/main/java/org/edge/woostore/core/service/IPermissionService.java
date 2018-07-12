package org.edge.woostore.core.service;



import org.edge.woostore.domain.entity.Permission;
import org.edge.woostore.domain.repository.Page;

import java.util.Collection;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface IPermissionService extends ICoreService<Permission>{
    Collection<Permission> getPermissions();
    Page getListByPage(int pageSize, int page, String filter);
    boolean updatePermission(Permission permission);
    boolean insertPermission(Permission permission);
}
