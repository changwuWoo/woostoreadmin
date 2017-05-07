package org.edge.woostore.core.service;

import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface IGroupService {
    @Transactional
    Connection queryByPkId(String pkid);
}
