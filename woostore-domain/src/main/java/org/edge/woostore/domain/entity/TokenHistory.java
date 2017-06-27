package org.edge.woostore.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Administrator on 2017/6/22.
 */
@Entity
@Table(name = "TB_TOKENHISTORY", schema = "WOOSTOREADMIN")
public class TokenHistory {
    private String pkId;
    private Timestamp ftime;
    private String faccesstoken;
    private String fkMasterId;
    private String fip;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "FTIME")
    public Timestamp getFtime() {
        return ftime;
    }

    public void setFtime(Timestamp ftime) {
        this.ftime = ftime;
    }

    @Basic
    @Column(name = "FACCESSTOKEN")
    public String getFaccesstoken() {
        return faccesstoken;
    }

    public void setFaccesstoken(String faccesstoken) {
        this.faccesstoken = faccesstoken;
    }

    @Basic
    @Column(name = "FK_MASTER_ID")
    public String getFkMasterId() {
        return fkMasterId;
    }

    public void setFkMasterId(String fkMasterId) {
        this.fkMasterId = fkMasterId;
    }

    @Basic
    @Column(name = "FIP")
    public String getFip() {
        return fip;
    }

    public void setFip(String fip) {
        this.fip = fip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenHistory that = (TokenHistory) o;
        return Objects.equals(pkId, that.pkId) &&
                Objects.equals(ftime, that.ftime) &&
                Objects.equals(faccesstoken, that.faccesstoken) &&
                Objects.equals(fkMasterId, that.fkMasterId) &&
                Objects.equals(fip, that.fip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, ftime, faccesstoken, fkMasterId, fip);
    }

    @Override
    public String toString() {
        return "TokenHistory{" +
                "pkId='" + pkId + '\'' +
                ", ftime=" + ftime +
                ", faccesstoken='" + faccesstoken + '\'' +
                ", fkMasterId='" + fkMasterId + '\'' +
                ", fip='" + fip + '\'' +
                '}';
    }
}
