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
@Table(name = "TB_POWER", schema = "WOOSTOREADMIN")
public class Power implements Serializable{
    private String pkId;
    @NotBlank
    private String fnumber;
    @NotBlank
    private String fname;
    private boolean fstatus;

    @Basic
    @Column(name = "FSTATUS",updatable = false)
    public boolean isFstatus() {
        return fstatus;
    }

    public void setFstatus(boolean fstatus) {
        this.fstatus = fstatus;
    }

    private Collection<Role> roleCollection = new ArrayList<>();
    @Transient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @Override
    public String toString() {
        return "Power{" +
                "pkId='" + pkId + '\'' +
                ", fnumber='" + fnumber + '\'' +
                ", fname='" + fname + '\'' +
                '}';
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power = (Power) o;
        return Objects.equals(pkId, power.pkId) &&
                Objects.equals(fnumber, power.fnumber) &&
                Objects.equals(fname, power.fname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, fnumber, fname);
    }
}
