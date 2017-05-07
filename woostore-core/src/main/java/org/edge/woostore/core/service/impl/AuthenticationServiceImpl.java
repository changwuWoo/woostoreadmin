package org.edge.woostore.core.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.edge.woostore.core.service.IAuthenticationService;
import org.edge.woostore.persist.dao.IMasterDao;
import org.edge.woostore.utils.util.KeyUtil;
import org.edge.woostore.utils.util.TokenUtils;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;


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
        try {
            token= TokenUtils.create(String.valueOf(KeyUtil.getKey(ContextLoader.getCurrentWebApplicationContext().getServletContext())),userName,"","",600000,19);
            logger.info("toke"+token);
        } catch (JoseException e) {
            e.printStackTrace();
        }
        return  token==null?"":token;
    }

}
