package org.edge.woostore.core.service.impl;

import org.edge.woostore.core.service.ICoreService;
import org.edge.woostore.core.service.IUserService;
import org.edge.woostore.domain.entity.Master;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/6.
 */
@Service("userService")
public class UserService implements IUserService, ICoreService {
    @Override
    public Master getUserByUserName(String name) {
        return null;
    }
    @Override
    public Master getUserByPkId(Master master) {
        return null;
    }
}
