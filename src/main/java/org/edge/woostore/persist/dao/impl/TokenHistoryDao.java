package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.TokenHistory;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.ITokenHistoryDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
@Repository
public class TokenHistoryDao extends AbstractCoreDao<TokenHistory,String> implements ITokenHistoryDao {
    @Override
    public int deleteByPrimaryKey(List<String> pkIds) {
        return 0;
    }

    @Override
    public int batchInsert(List<TokenHistory> records) {
        return 0;
    }

    @Override
    public int insertSelective(TokenHistory record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(TokenHistory record) {
        return 0;
    }
}
