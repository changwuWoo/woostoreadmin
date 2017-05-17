package org.edge.woostore.core.service.impl;

import org.edge.woostore.core.service.ICoreService;
import org.edge.woostore.core.service.IUserService;
import org.edge.woostore.domain.entity.Master;
import org.edge.woostore.persist.dao.IMasterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/6.
 */
@Service("userService")
public class UserService implements IUserService, ICoreService {
    @Autowired
    @Qualifier("masterDao")
    private IMasterDao iMasterDao;
    @Override
    public Master getUserByUserName(String name) {
        return iMasterDao.selectByName(name);
    }
    @Override
    public Master getUserByPkId(Master master) {
        return iMasterDao.selectByPrimaryKey(master.getPkId());
    }
}
