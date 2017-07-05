package org.edge.woostore.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/2.
 */
@Entity
@Table(name = "TB_MEMBER", schema = "WOOSTOREADMIN")
public class Member implements Serializable {
    private String pkId;
    private String loginName;
    private String loginPassWord;
    private String nikeName;
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
    @Column(name = "LOGINNAME")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginname) {
        this.loginName = loginname;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getLoginPassWord() {
        return loginPassWord;
    }

    public void setLoginPassWord(String loginpassword) {
        this.loginPassWord = loginpassword;
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
        Member member = (Member) o;
        return Objects.equals(pkId, member.pkId) &&
                Objects.equals(loginName, member.loginName) &&
                Objects.equals(loginPassWord, member.loginPassWord) &&
                Objects.equals(nikeName, member.nikeName) &&
                Objects.equals(baseStatus, member.baseStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, loginName, loginPassWord, nikeName, baseStatus);
    }
}
