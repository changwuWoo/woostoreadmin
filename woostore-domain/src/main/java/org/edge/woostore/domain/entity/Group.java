package org.edge.woostore.domain.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Administrator on 2017/5/20.
 */
@Entity
@Table(name = "TB_GROUP", schema = "WOOSTOREADMIN")
public class Group implements Serializable{
    private String pkId;
    @NotNull
    private String parentId;
    @NotBlank
    private String fnumber;
    @NotBlank
    private String fname;
    private boolean isLeaf;
    private boolean isRoot;

    @Basic
    @Column(name = "ISROOT")
    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    private Collection<Group> children =new ArrayList<Group>();
    private Collection<Master> masterCollection=new ArrayList<Master>();

    @Basic
    @Column(name = "ISLEAF")
    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    @Transient
    public Collection<Master> getMasterCollection() {
        return masterCollection;
    }

    public void setMasterCollection(Collection<Master> masterCollection) {
        this.masterCollection = masterCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return isLeaf() == group.isLeaf() &&
                Objects.equals(getPkId(), group.getPkId()) &&
                Objects.equals(getParentId(), group.getParentId()) &&
                Objects.equals(getFnumber(), group.getFnumber()) &&
                Objects.equals(getFname(), group.getFname()) &&
                Objects.equals(getChildren(), group.getChildren()) &&
                Objects.equals(getMasterCollection(), group.getMasterCollection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkId(), getParentId(), getFnumber(), getFname(), isLeaf(), getChildren(), getMasterCollection());
    }

    @Override
    public String toString() {
        return "Group{" +
                "pkId='" + pkId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", fnumber='" + fnumber + '\'' +
                ", fname='" + fname + '\'' +
                ", isLeaf=" + isLeaf +
                ", children=" + children +
                ", masterCollection=" + masterCollection +
                '}';
    }

    @Transient
    public Collection<Group> getChildren() {
        return children;
    }

    public void setChildren(Collection<Group> children) {
        this.children = children;
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
    @Column(name = "PARENT_ID")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "FNUMBER")
    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    @Basic
    @Column(name = "FNAME")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

}
