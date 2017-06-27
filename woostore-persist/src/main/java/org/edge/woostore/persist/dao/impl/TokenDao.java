package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.persist.dao.AbstractRedisDao;
import org.edge.woostore.persist.dao.ITokenDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/10.
 */
@Repository
public class TokenDao extends AbstractRedisDao implements ITokenDao {
}
