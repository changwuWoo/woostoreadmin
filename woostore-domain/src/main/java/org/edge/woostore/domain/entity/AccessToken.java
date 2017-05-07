package org.edge.woostore.domain.entity;

import java.util.Objects;

/**
 * Created by Administrator on 2017/5/7.
 */
public class AccessToken {
    private String ip;
    private String accessToken;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccessToken)) return false;
        AccessToken that = (AccessToken) o;
        return Objects.equals(getIp(), that.getIp()) &&
                Objects.equals(getAccessToken(), that.getAccessToken());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIp(), getAccessToken());
    }
}
