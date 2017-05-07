package org.edge.woostore.core.service;

import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2017/4/17.
 */
public interface IAuthenticationService {
    @Transactional
    String authenticate(String userName);
}
