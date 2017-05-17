package org.edge.woostore.domain.entity;

/**
 * Created by Administrator on 2017/5/7.
 */
public class Token {
    private String ip;
    private String AccessToken;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }
}
