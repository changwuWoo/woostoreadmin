package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Log;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.ILogDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/23.
 */
@Repository
public class LogDao extends AbstractCoreDao<Log,String> implements ILogDao {

    @Override
    public String save(Log entity) {
        return null;
    }

    @Override
    public boolean isExistByName(String hql, Map<String,Object> map) {
        return false;
    }

    @Override
    public int deleteByPrimaryKey(List<String> pkIds) {
        return 0;
    }


    @Override
    public int batchInsert(List<Log> records) {
        return 0;
    }

    @Override
    public int insertSelective(Log record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Log record) {
        return 0;
    }

}
