package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.City;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.ICityDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Repository
public class CityDao extends AbstractCoreDao<City,String> implements ICityDao{
    @Override
    public int deleteByPrimaryKey(List<String> pkIds) {
        return 0;
    }

    @Override
    public int batchInsert(List<City> records) {
        return 0;
    }

    @Override
    public int insertSelective(City record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(City record) {
        return 0;
    }
}
