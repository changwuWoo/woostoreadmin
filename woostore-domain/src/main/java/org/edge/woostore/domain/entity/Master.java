package org.edge.woostore.domain.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Administrator on 2017/5/19.
 */
@Entity
@Table(name = "TB_MASTER", schema = "WOOSTOREADMIN")
public class Master implements Serializable{
    private String pkId;
    @NotBlank
    private String fname;
    private String fpasswd;
    private boolean fstatus;
    private String pkGroupId;
    private String pkRoleId;
    private Group group=new Group();
    @Transient
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private Collection<Group> groupCollection=new ArrayList<>();
    private Role role=new Role();
    private Collection<Power> powerCollection = new ArrayList<>();
    @Transient
    public Collection<Power> getPowerCollection() {
        return powerCollection;
    }

    public void setPowerCollection(Collection<Power> powerCollection) {
        this.powerCollection = powerCollection;
    }

    @Transient
    public Collection<Group> getGroupCollection() {
        return groupCollection;
    }

    public void setGroupCollection(Collection<Group> groupCollection) {
        this.groupCollection = groupCollection;
    }

    @Transient
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "FNAME")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "FPASSWD")
    public String getFpasswd() {
        return fpasswd;
    }

    public void setFpasswd(String fpasswd) {
        this.fpasswd = fpasswd;
    }

    @Basic
    @Column(name = "FSTATUS")
    public boolean isFstatus() {
        return fstatus;
    }

    public void setFstatus(boolean fstatus) {
        this.fstatus = fstatus;
    }

    @Basic
    @Column(name = "FK_GROUP_ID")
    public String getPkGroupId() {
        return pkGroupId;
    }

    public void setPkGroupId(String pkGroupId) {
        this.pkGroupId = pkGroupId;
    }

    @Basic
    @Column(name = "FK_ROLE_ID")
    public String getPkRoleId() {
        return pkRoleId;
    }

    public void setPkRoleId(String pkRoleId) {
        this.pkRoleId = pkRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return fstatus == master.fstatus &&
                Objects.equals(pkId, master.pkId) &&
                Objects.equals(fname, master.fname) &&
                Objects.equals(fpasswd, master.fpasswd) &&
                Objects.equals(pkGroupId, master.pkGroupId) &&
                Objects.equals(pkRoleId, master.pkRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, fname, fpasswd, fstatus, pkGroupId, pkRoleId);
    }

    @Override
    public String toString() {
        return "Master{" +
                "pkId='" + pkId + '\'' +
                ", fname='" + fname + '\'' +
                ", fpasswd='" + fpasswd + '\'' +
                ", fstatus=" + fstatus +
                ", pkGroupId='" + pkGroupId + '\'' +
                ", pkRoleId='" + pkRoleId + '\'' +
                ", groupCollection=" + groupCollection +
                ", role=" + role +
                '}';
    }
}
