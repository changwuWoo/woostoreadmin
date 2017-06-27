package org.edge.woostore.domain.security;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/21.
 */
public class Token implements Serializable{
    private String fMaterId;
    private String fAccessToken;

    public String getfMaterId() {
        return fMaterId;
    }

    public void setfMaterId(String fMaterId) {
        this.fMaterId = fMaterId;
    }

    public String getfAccessToken() {
        return fAccessToken;
    }

    public void setfAccessToken(String fAccessToken) {
        this.fAccessToken = fAccessToken;
    }
}
