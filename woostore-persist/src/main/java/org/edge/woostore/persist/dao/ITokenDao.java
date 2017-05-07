package org.edge.woostore.persist.dao;

import org.edge.woostore.domain.dto.JwtToken;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface ITokenDao {
    public JwtToken selectByPrimaryKey(String key);
    public void selectByPrimaryvalue(String value);
}
