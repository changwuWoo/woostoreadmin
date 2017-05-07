package org.edge.woostore.core.service;

import org.edge.woostore.domain.entity.Master;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/6.
 */
public interface IUserService {
    @Transactional
    Master getUserByUserName(String name);
    @Transactional
    Master getUserByPkId(Master master);
}
