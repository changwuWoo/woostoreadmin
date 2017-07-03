package org.edge.woostore.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/3.
 */
@Entity
@Table(name = "TB_ORDERPAYINFO", schema = "WOOSTOREADMIN")
public class OrderPayInfo {
    private String pkId;
    private String fkPayTypeId;
    private Timestamp payTime;
    private BigDecimal goodsAmount;
    private BigDecimal payAmount;
    private BigDecimal freight;
    private BigDecimal discount;
    private BigDecimal coupon;
    private BigDecimal payDiscount;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "FKPAYTYPEID")
    public String getFkPayTypeId() {
        return fkPayTypeId;
    }

    public void setFkPayTypeId(String fkpaytypeid) {
        this.fkPayTypeId = fkpaytypeid;
    }

    @Basic
    @Column(name = "PAYTIME")
    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp paytime) {
        this.payTime = paytime;
    }

    @Basic
    @Column(name = "GOODSAMOUNT")
    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsamount) {
        this.goodsAmount = goodsamount;
    }

    @Basic
    @Column(name = "PAYAMOUNT")
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payamount) {
        this.payAmount = payamount;
    }

    @Basic
    @Column(name = "FREIGHT")
    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    @Basic
    @Column(name = "DISCOUNT")
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "COUPON")
    public BigDecimal getCoupon() {
        return coupon;
    }

    public void setCoupon(BigDecimal coupon) {
        this.coupon = coupon;
    }

    @Basic
    @Column(name = "PAYDISCOUNT")
    public BigDecimal getPayDiscount() {
        return payDiscount;
    }

    public void setPayDiscount(BigDecimal paydiscount) {
        this.payDiscount = paydiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPayInfo that = (OrderPayInfo) o;
        return Objects.equals(pkId, that.pkId) &&
                Objects.equals(fkPayTypeId, that.fkPayTypeId) &&
                Objects.equals(payTime, that.payTime) &&
                Objects.equals(goodsAmount, that.goodsAmount) &&
                Objects.equals(payAmount, that.payAmount) &&
                Objects.equals(freight, that.freight) &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(coupon, that.coupon) &&
                Objects.equals(payDiscount, that.payDiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, fkPayTypeId, payTime, goodsAmount, payAmount, freight, discount, coupon, payDiscount);
    }
}
