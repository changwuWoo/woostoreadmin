package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Goods;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.IGoodsDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Repository
public class GoodsDao extends AbstractCoreDao<Goods,String> implements IGoodsDao{
    @Override
    public int deleteByPrimaryKey(List<String> pkIds) {
        return 0;
    }

    @Override
    public int batchInsert(List<Goods> records) {
        return 0;
    }

    @Override
    public int insertSelective(Goods record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return 0;
    }
}
