package org.edge.woostore.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/2.
 */
@Entity
@Table(name = "TB_ORDERDELIVERYINFO", schema = "WOOSTOREADMIN")
public class OrderDeliveryInfo implements Serializable {
    private String pkId;
    private String fkDeliveryId;
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
    @Column(name = "FKDELIVERYID")
    public String getFkDeliveryId() {
        return fkDeliveryId;
    }

    public void setFkDeliveryId(String fkdeliveryid) {
        this.fkDeliveryId = fkdeliveryid;
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
        OrderDeliveryInfo that = (OrderDeliveryInfo) o;
        return Objects.equals(pkId, that.pkId) &&
                Objects.equals(fkDeliveryId, that.fkDeliveryId) &&
                Objects.equals(baseStatus, that.baseStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, fkDeliveryId, baseStatus);
    }
}
