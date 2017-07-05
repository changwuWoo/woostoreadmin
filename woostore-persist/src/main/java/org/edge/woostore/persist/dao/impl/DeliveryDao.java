package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Delivery;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.IDeliveryDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Repository
public class DeliveryDao extends AbstractCoreDao<Delivery,String> implements IDeliveryDao{
    @Override
    public int deleteByPrimaryKey(List<String> pkIds) {
        return 0;
    }

    @Override
    public int batchInsert(List<Delivery> records) {
        return 0;
    }

    @Override
    public int insertSelective(Delivery record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Delivery record) {
        return 0;
    }
}
