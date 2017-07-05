package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Brand;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.IBrandDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Repository
public class BrandDao extends AbstractCoreDao<Brand,String> implements IBrandDao{
    @Override
    public int deleteByPrimaryKey(List<String> pkIds) {
        return 0;
    }

    @Override
    public int batchInsert(List<Brand> records) {
        return 0;
    }

    @Override
    public int insertSelective(Brand record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Brand record) {
        return 0;
    }
}
