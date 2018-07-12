package org.woo.persist.dao;

import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/12.
 */
public interface ICoreDao<T, PK extends Serializable> {
    /**
     * 根据ID获取实体对象.
     *
     * @param id 记录ID
     * @return 实体对象
     */

    T get(PK id);

    /**
     * 保存实体对象.
     *
     * @param entity 对象
     * @return ID
     */

    PK save(T entity);

    //分页查询
    Collection<T> queryForPage(final int offset, final int length, String hql, Map<String, Object> map);

    //总记录条数
    int getCount(String hql);

    boolean isExistByName(String hql, Map<String, Object> map);

    int deleteByPrimaryKey(String hql, Map<String, Object> map);

    int deleteByPrimaryKey(List<String> pkIds);

    int insert(String sql, Map<String, Object> map);

    int batchInsert(List<T> records);

    int insertSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(String sql, Map<String, Object> map);

    Collection<T> selectAll(String hql, Map<String, Object> map);

    Query<T> hqlQueryBuilder(String hql, Map<String, Object> map);

    Query<T> sqlQueryBuilder(String sql, Map<String, Object> map);

    Collection<T> selectByFiled(String hql, Map<String, Object> map);

    T selectByUniqueFiled(String hql, Map<String, Object> map);

    String getSeq(String sql);
}
