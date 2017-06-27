package org.edge.woostore.domain.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Administrator on 2017/5/20.
 */
@Entity
@Table(name = "TB_PRIVILEGE", schema = "WOOSTOREADMIN")
public class Privilege implements Serializable{
    private String pkId;
    @NotBlank
    private String privilegemaster;
    @NotBlank
    private String privilegemastervalue;
    @NotBlank
    private String privilegeaccess;
    @NotBlank
    private String privilegeaccessvalue;
    private boolean privilegeoperation;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "PRIVILEGEMASTER")
    public String getPrivilegemaster() {
        return privilegemaster;
    }

    public void setPrivilegemaster(String privilegemaster) {
        this.privilegemaster = privilegemaster;
    }

    @Basic
    @Column(name = "PRIVILEGEMASTERVALUE")
    public String getPrivilegemastervalue() {
        return privilegemastervalue;
    }

    public void setPrivilegemastervalue(String privilegemastervalue) {
        this.privilegemastervalue = privilegemastervalue;
    }

    @Basic
    @Column(name = "PRIVILEGEACCESS")
    public String getPrivilegeaccess() {
        return privilegeaccess;
    }

    public void setPrivilegeaccess(String privilegeaccess) {
        this.privilegeaccess = privilegeaccess;
    }

    @Basic
    @Column(name = "PRIVILEGEACCESSVALUE")
    public String getPrivilegeaccessvalue() {
        return privilegeaccessvalue;
    }

    public void setPrivilegeaccessvalue(String privilegeaccessvalue) {
        this.privilegeaccessvalue = privilegeaccessvalue;
    }

    @Basic
    @Column(name = "PRIVILEGEOPERATION")
    public boolean isPrivilegeoperation() {
        return privilegeoperation;
    }

    public void setPrivilegeoperation(boolean privilegeoperation) {
        this.privilegeoperation = privilegeoperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privilege privilege = (Privilege) o;
        return privilegeoperation == privilege.privilegeoperation &&
                Objects.equals(pkId, privilege.pkId) &&
                Objects.equals(privilegemaster, privilege.privilegemaster) &&
                Objects.equals(privilegemastervalue, privilege.privilegemastervalue) &&
                Objects.equals(privilegeaccess, privilege.privilegeaccess) &&
                Objects.equals(privilegeaccessvalue, privilege.privilegeaccessvalue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, privilegemaster, privilegemastervalue, privilegeaccess, privilegeaccessvalue, privilegeoperation);
    }
}
