package org.edge.woostore.persist.dao;

import org.edge.woostore.domain.entity.Token;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface ITokenDao extends ICoreDao<Token,String>{
    public Token selectByPrimaryKey(String key);
    public void selectByPrimaryvalue(String value);
}
