package org.edge.woostore.domain.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Administrator on 2017/5/16.
 */
@Entity
@Table(name = "TB_TOKEN", schema = "WOOSTOREADMIN")
public class AccessToken {
    private String pkId;
    private String ip;
    private String accesstoken;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "IP")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "ACCESSTOKEN")
    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessToken that = (AccessToken) o;
        return Objects.equals(pkId, that.pkId) &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(accesstoken, that.accesstoken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, ip, accesstoken);
    }
}
