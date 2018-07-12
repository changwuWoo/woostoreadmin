package org.woo.persist.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;

/**
 * Created by Administrator on 2017/4/12.
 */
public interface ICoreDao<T, PK extends Serializable>{
    /**
     * 根据ID获取实体对象.
     *
     * @param id
     *  记录ID
     * @return 实体对象
     */

    @Transactional
    T get(PK id);

    /**
     * 保存实体对象.
     *
     * @param entity
     *            对象
     * @return ID
     */
    @Transactional
    PK save(T entity);

    //分页查询
    @Transactional
    Collection<T> queryForPage(final int offset, final int length,String hql,Map<String,Object> map);

    //总记录条数
    @Transactional
    int getCount(String hql);
    @Transactional
    boolean isExistByName(String hql, Map<String,Object> map);
    @Transactional
    int deleteByPrimaryKey(String hql,Map<String,Object> map);
    @Transactional
    int deleteByPrimaryKey(List<String> pkIds);
    @Transactional
    int insert(String sql,Map<String,Object> map);
    @Transactional
    int batchInsert(List<T> records);
    @Transactional
    int insertSelective(T record);
    @Transactional
    int updateByPrimaryKeySelective(T record);
    @Transactional
    int updateByPrimaryKey(String sql,Map<String,Object> map);
    @Transactional
    Collection<T> selectAll(String hql,Map<String,Object> map);
    @Transactional
    Query<T> hqlQueryBuilder(String hql, Map<String,Object> map);
    @Transactional
    Query<T> sqlQueryBuilder(String sql, Map<String,Object> map);
    @Transactional
    Collection<T> selectByFiled(String hql,Map<String,Object> map);
    @Transactional
    T selectByUniqueFiled(String hql,Map<String,Object> map);
    @Transactional
    String getSeq(String sql);
}
