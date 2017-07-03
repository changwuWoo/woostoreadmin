package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Permission;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.IPowerDao;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/19.
 */
@Repository
public class PowerDaoImpl extends AbstractCoreDao<Permission,String> implements IPowerDao {
    @Override
    public int deleteByPrimaryKey(String hql, Map map) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(List<String> pkIds) {
        return 0;
    }

    @Override
    public int batchinsert(List<Permission> records) {
        return 0;
    }

    @Override
    public int insertSelective(Permission record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return 0;
    }

    @Override
    public Collection<Permission> selectListByPrivilegeMaster(String privileMasterValue) {
        String sql = "SELECT  tpower.PK_ID AS pkId,tpower.FNAME AS fname,tpower.FNUMBER AS fnumber from STSM2017S.TB_POWER tpower " +
                "LEFT OUTER JOIN STSM2017S.TB_PRIVILEGE tpri ON tpower.PK_ID=tpri.PRIVILEGEACCESSVALUE " +
                "WHERE tpri.PRIVILEGEMASTERVALUE = ?";
        Collection<Permission> privilegeCollection = getSession().createSQLQuery(sql).setParameter(0,privileMasterValue).list();
        return privilegeCollection;
    }
}
