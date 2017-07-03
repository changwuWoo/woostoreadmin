package org.edge.woostore.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/2.
 */
@Entity
@Table(name = "TB_DELIVERY", schema = "WOOSTOREADMIN")
public class Delivery {
    private String pkId;
    private String fkMemberId;
    private String region;
    private String detailAddress;
    private String nikeName;
    private String mobile;
    private String phone;
    private BigDecimal baseStatus;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "FKMEMBERID")
    public String getFkMemberId() {
        return fkMemberId;
    }

    public void setFkMemberId(String fkmemberid) {
        this.fkMemberId = fkmemberid;
    }

    @Basic
    @Column(name = "REGION")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "DETAILADDRESS")
    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Basic
    @Column(name = "NIKENAME")
    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikename) {
        this.nikeName = nikename;
    }

    @Basic
    @Column(name = "MOBILE")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "BASESTATUS")
    public BigDecimal getBaseStatus() {
        return baseStatus;
    }

    public void setBaseStatus(BigDecimal basestatus) {
        this.baseStatus = basestatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(pkId, delivery.pkId) &&
                Objects.equals(fkMemberId, delivery.fkMemberId) &&
                Objects.equals(region, delivery.region) &&
                Objects.equals(detailAddress, delivery.detailAddress) &&
                Objects.equals(nikeName, delivery.nikeName) &&
                Objects.equals(mobile, delivery.mobile) &&
                Objects.equals(phone, delivery.phone) &&
                Objects.equals(baseStatus, delivery.baseStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, fkMemberId, region, detailAddress, nikeName, mobile, phone, baseStatus);
    }
}
