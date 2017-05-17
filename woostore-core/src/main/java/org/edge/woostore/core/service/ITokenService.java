package org.edge.woostore.core.service;

import org.edge.woostore.domain.dto.JwtToken;
import org.edge.woostore.domain.entity.Token;
import org.jose4j.jwt.consumer.InvalidJwtException;

/**
 * Created by Administrator on 2017/3/27.
 */
public interface ITokenService {
    /**
     * 创建一个token关联上指定用户
     * @param @userId 指定用户的id
     * @return 生成的token
     */
    //根据用户名来创建Token
    String insert(String userName);
    /*
    *验证Token
    *验证不和法的情况jose4j会抛出一个异常
    *
    */
    boolean vaildToken(Token token) throws InvalidJwtException;
    Token getTokenByAccessToken(String AccessToken);
    Token getTokenByIp(String ip);
    /**
     * 清除token
     * @param userId 登录用户的id
     */
    public void deleteToken(String userId);
    public void updateTokneByIp(String ip);
}
