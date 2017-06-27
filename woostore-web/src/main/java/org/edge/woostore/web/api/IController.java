package org.edge.woostore.web.api;

import org.edge.woostore.domain.repository.Page;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/25.
 */
public interface IController<E> {
    /*
    *验证Token
    *验证不和法的情况jose4j会抛出一个异常
    *
    */
    Map resultPageUtil(Page<E> tPage);
    Map resultCollectionUtil(Collection<E> eCollection);
    Map resultEUtil(E e);
}
