package org.edge.woostore.core.service.impl;

import org.edge.woostore.core.service.ITokenService;
import org.edge.woostore.domain.dto.JwtToken;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/7.
 */
@Service("tokenService")
public class TokenService implements ITokenService{

    @Override
    public String insert(String userName) {
        return null;
    }

    @Override
    public boolean getTokenBy(JwtToken token) throws InvalidJwtException {
        return false;
    }

    @Override
    public JwtToken getToken(String appId) {
        return null;
    }

    @Override
    public void deleteToken(String userId) {

    }

    @Override
    public void updateTokneByIp(String ip) {

    }
}
