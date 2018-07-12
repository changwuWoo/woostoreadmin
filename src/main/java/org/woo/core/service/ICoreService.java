package org.woo.core.service;


import org.woo.domain.repository.Page;

/**
 * Created by Administrator on 2017/4/16.
 */
public interface ICoreService<T> {
    Page<T> getListByPage(int pageSize, int page,T t);
    String getSeq();
    T getEntityByPkId(String pkId);
}
