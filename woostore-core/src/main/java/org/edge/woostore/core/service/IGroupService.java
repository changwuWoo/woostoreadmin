package org.edge.woostore.core.service;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface IGroupService {
    Connection queryByPkId(String pkid);
}
