package org.edge.woostore.core.service.impl;

import org.edge.woostore.core.service.IGroupService;
import org.springframework.stereotype.Service;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/4/24.
 */
@Service(value = "groupService")
public class GroupService implements IGroupService {
    @Override
    public Connection queryByPkId(String pkid) {
        return null;
    }
}
