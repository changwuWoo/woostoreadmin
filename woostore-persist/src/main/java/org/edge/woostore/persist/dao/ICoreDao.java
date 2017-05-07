package org.edge.woostore.persist.dao;


import org.edge.woostore.domain.entity.Master;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
public interface ICoreDao<T, PK extends Serializable> {

    /**
     * 根据ID获取实体对象.
     *
     * @param id 记录ID
     * @return 实体对象
     */
    public T get(PK id);

    /**
     * 保存实体对象.
     *
     * @param entity 对象
     * @return ID
     */
    public PK save(T entity);

    public int deleteByPrimaryKey(String pkId);
    public boolean insert(T record);
    public  int insertSelective(T record);

    public  T selectByPrimaryKey(String pkId);

    public  int updateByPrimaryKeySelective(T record);

    public  boolean updateByPrimaryKey(T record);

    public  Master selectByName(String name);

    public  boolean insert(List<T> list);
    /**
     * 根据用户名判断此用户是否存在（不区分大小写）
     */
    public boolean isExistByUsername(String name);
}
