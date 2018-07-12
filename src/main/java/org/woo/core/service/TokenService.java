package org.woo.core.service;

import org.woo.core.service.ITokenService;
import org.woo.persist.dao.ITokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/21.
 */
@Service
public class TokenService implements ITokenService{
    @Autowired
    private ITokenDao iTokenDao;
    @Override
    public Object getTokenByMaterId(String masterId) {
        return iTokenDao.get(masterId);
    }

    @Override
    public boolean updateToken(String key, String accessToken) {
        if(!key.isEmpty()&&!accessToken.isEmpty()){
            iTokenDao.set(key,accessToken);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean removeToken(String masterId) {
        if (iTokenDao.exists(masterId)){
            iTokenDao.remove(masterId);
            return true;
        }else {
            return false;
        }
    }
}
