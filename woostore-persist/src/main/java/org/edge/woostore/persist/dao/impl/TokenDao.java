package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Token;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.ITokenDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
@Repository
public class TokenDao extends AbstractCoreDao<Token,String> implements ITokenDao {


    @Override
    public void selectByPrimaryvalue(String value) {

    }

    @Override
    public int deleteByPrimaryKey(String pkId) {
        return 0;
    }

    @Override
    public boolean insert(Token record) {
        return false;
    }

    @Override
    public int insertSelective(Token record) {
        return 0;
    }

    @Override
    public Token selectByPrimaryKey(String pkId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Token record) {
        return 0;
    }

    @Override
    public boolean updateByPrimaryKey(Token record) {
        return false;
    }

    @Override
    public Token selectByName(String name) {
        return null;
    }

    @Override
    public boolean insert(List<Token> list) {
        return false;
    }

    @Override
    public boolean isExistByUsername(String name) {
        return false;
    }
}
