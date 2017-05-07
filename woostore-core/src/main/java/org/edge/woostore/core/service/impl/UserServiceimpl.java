package org.edge.woostore.core.service.impl;

import org.edge.woostore.core.service.IUserService;
import org.edge.woostore.domain.entity.Master;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/6.
 */
@Service("userServiceimpl")
public class UserServiceimpl extends CoreServiceImpl implements IUserService {
    @Override
    public Master getUserByUserName(String name) {
        return null;
    }
    @Override
    public Master getUserByPkId(Master master) {
        return null;
    }
}
