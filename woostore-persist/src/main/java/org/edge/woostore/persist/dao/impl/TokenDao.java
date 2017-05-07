package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.dto.JwtToken;
import org.edge.woostore.domain.entity.Master;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.ITokenDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
@Repository
public class TokenDao extends AbstractCoreDao<JwtToken,String> implements ITokenDao {


    @Override
    public void selectByPrimaryvalue(String value) {

    }

    @Override
    public int deleteByPrimaryKey(String pkId) {
        return 0;
    }

    @Override
    public boolean insert(JwtToken record) {
        return false;
    }

    @Override
    public int insertSelective(JwtToken record) {
        return 0;
    }

    @Override
    public JwtToken selectByPrimaryKey(String pkId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(JwtToken record) {
        return 0;
    }

    @Override
    public boolean updateByPrimaryKey(JwtToken record) {
        return false;
    }

    @Override
    public Master selectByName(String name) {
        return null;
    }

    @Override
    public boolean insert(List<JwtToken> list) {
        return false;
    }

    @Override
    public boolean isExistByUsername(String name) {
        return false;
    }
}
