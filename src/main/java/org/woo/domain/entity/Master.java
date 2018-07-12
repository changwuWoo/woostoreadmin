package org.woo.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/2.
 */
@Entity
@Table(name = "TB_MASTER", schema = "WOOSTOREADMIN")
public class Master implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -819205826453419843L;
	private String pkId;
    private String loginName;
    private String loginPassWord;
    private BigDecimal baseStatus;
    private String fkGroupId;
    private String fkRoleId;
    private Collection<Group> groupCollection;
    private Collection<Permission> powerCollection;
    private Role role;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "MASTERNAME")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginname) {
        this.loginName = loginname;
    }

    @Basic
    @Column(name = "MASTERPASSWORD")
    public String getLoginPassWord() {
        return loginPassWord;
    }

    public void setLoginPassWord(String loginpassword) {
        this.loginPassWord = loginpassword;
    }

    @Basic
    @Column(name = "BASESTATUS")
    public BigDecimal getBaseStatus() {
        return baseStatus;
    }

    public void setBaseStatus(BigDecimal basestatus) {
        this.baseStatus = basestatus;
    }

    @Basic
    @Column(name = "FKGROUPID")
    public String getFkGroupId() {
        return fkGroupId;
    }

    public void setFkGroupId(String fkgroupid) {
        this.fkGroupId = fkgroupid;
    }

    @Basic
    @Column(name = "FKROLEID")
    public String getFkRoleId() {
        return fkRoleId;
    }

    public void setFkRoleId(String fkroleid) {
        this.fkRoleId = fkroleid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return Objects.equals(pkId, master.pkId) &&
                Objects.equals(loginName, master.loginName) &&
                Objects.equals(loginPassWord, master.loginPassWord) &&
                Objects.equals(baseStatus, master.baseStatus) &&
                Objects.equals(fkGroupId, master.fkGroupId) &&
                Objects.equals(fkRoleId, master.fkRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, loginName, loginPassWord, baseStatus, fkGroupId, fkRoleId);
    }

    public void setGroupCollection(Collection<Group> groupCollection) {
        this.groupCollection = groupCollection;
    }

    @Transient
    public Collection<Group> getGroupCollection() {
        return groupCollection;
    }
  
    public void setRole(Role role) {
        this.role = role;
    }
    @Transient
    public Role getRole() {
        return role;
    }
    @Transient
    public Collection<Permission> getPowerCollection() {
        return powerCollection;
    }

    public void setPowerCollection(Collection<Permission> powerCollection) {
        this.powerCollection = powerCollection;
    }
}
