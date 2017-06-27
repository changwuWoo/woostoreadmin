package org.edge.woostore.persist.dao;

import org.edge.woostore.domain.entity.Power;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface IPowerDao extends CoreDao<Power,String>{
    @Transactional
    Collection<Power> selectListByPrivilegeMaster(String privileMasterValue);
}
