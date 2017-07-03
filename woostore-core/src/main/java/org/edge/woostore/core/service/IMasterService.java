package org.edge.woostore.core.service;

import org.edge.woostore.domain.entity.Master;

import java.util.Collection;

/**
 * Created by Administrator on 2017/4/6.
 */
public interface IMasterService extends ICoreService<Master>{
    boolean updateLogOutDate(Master user);
    Master getMasterInfoById(String pkId);
    Collection<Master> getUsers();
    Master queryByUserName(String name);
    boolean updateMasterInfo(Master master);
    Master getMaster(String pkId);
    boolean insertMaster(Master master);
}
