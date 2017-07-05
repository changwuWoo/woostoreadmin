package org.edge.woostore.persist.dao.impl;

import org.edge.woostore.domain.entity.Member;
import org.edge.woostore.persist.dao.AbstractCoreDao;
import org.edge.woostore.persist.dao.IMemberDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Repository
public class MemberDao extends AbstractCoreDao<Member,String> implements IMemberDao{
    @Override
    public int deleteByPrimaryKey(List<String> pkIds) {
        return 0;
    }

    @Override
    public int batchInsert(List<Member> records) {
        return 0;
    }

    @Override
    public int insertSelective(Member record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Member record) {
        return 0;
    }
}
