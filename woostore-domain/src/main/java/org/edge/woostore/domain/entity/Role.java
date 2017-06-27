package org.edge.woostore.domain.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Administrator on 2017/5/20.
 */
@Entity
@javax.persistence.Table(name = "TB_ROLE", schema = "WOOSTOREADMIN")
public class Role implements Serializable{
    private String pkId;

    @Id
    @javax.persistence.Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @NotBlank
    private String fname;

    @Basic
    @javax.persistence.Column(name = "FNAME")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @NotBlank
    private String fnumber;

    @Basic
    @javax.persistence.Column(name = "FNUMBER")
    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    private boolean fstatus;

    @Basic
    @javax.persistence.Column(name = "FSTATUS")
    public boolean isFstatus() {
        return fstatus;
    }

    public void setFstatus(boolean fstatus) {
        this.fstatus = fstatus;
    }


    private Collection<Power> powerCollection=new ArrayList<>();
    @Transient
    public Collection<Power> getPowerCollection() {
        return powerCollection;
    }

    public void setPowerCollection(Collection<Power> powerCollection) {
        this.powerCollection = powerCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return fstatus == role.fstatus &&
                Objects.equals(pkId, role.pkId) &&
                Objects.equals(fname, role.fname) &&
                Objects.equals(fnumber, role.fnumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, fname, fnumber, fstatus);
    }

    @Override
    public String toString() {
        return "Role{" +
                "pkId='" + pkId + '\'' +
                ", fname='" + fname + '\'' +
                ", fnumber='" + fnumber + '\'' +
                ", fstatus=" + fstatus +
                ", powerCollection=" + powerCollection +
                '}';
    }
}
