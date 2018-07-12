package org.woo.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woo.persist.dao.ITokenDao;

/**
 * Created by Administrator on 2017/6/21.
 */
@Service
public class TokenService implements ITokenService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ITokenDao iTokenDao;

    @Override
    public Object getTokenByMaterId(String masterId) {
        return iTokenDao.get(masterId);
    }

    @Override
    public boolean updateToken(String key, String accessToken) {
        if (!key.isEmpty() && !accessToken.isEmpty()) {
            iTokenDao.set(key, accessToken);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeToken(String masterId) {
        if (iTokenDao.exists(masterId)) {
            iTokenDao.remove(masterId);
            return true;
        } else {
            return false;
        }
    }
}
