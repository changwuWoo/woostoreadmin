package org.edge.woostore.core.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.edge.woostore.core.service.IAuthenticationService;
import org.edge.woostore.persist.dao.IMasterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/3/29.
 */
@Service("authenticationServiceImpl")
public class AuthenticationServiceImpl implements IAuthenticationService {
    private Log logger = LogFactory.getLog(AuthenticationServiceImpl.class);
    @Autowired
    @Qualifier("masterDao")
    private IMasterDao masterDao;
    @Override
    public String authenticate(String userName){
        String token=null;
        return  token==null?"":token;
    }

}
