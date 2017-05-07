package org.edge.woostore.core.service;

import org.edge.woostore.domain.entity.Master;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/6.
 */
public interface IUserService {
    Master getUserByUserName(String name);
    Master getUserByPkId(Master master);
}
