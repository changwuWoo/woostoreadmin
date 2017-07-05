package org.edge.woostore.core.service;


import org.edge.woostore.domain.repository.Page;

/**
 * Created by Administrator on 2017/4/16.
 */
public interface ICoreService<T> {
    Page getListByPage(int pageSize, int page,T t);
    String getSeq();
    T getEntityByPkId(String pkId);
}
