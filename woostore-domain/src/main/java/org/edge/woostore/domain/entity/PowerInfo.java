package org.edge.woostore.domain.entity;

import java.math.BigDecimal;

public class PowerInfo {
    private String pkPowerId;

    private String fnumber;

    private String fname;

    private String privilegemaster;

    private String privilegemastervalue;

    private String privilegeaccess;

    private String privilegeaccessvalue;

    private BigDecimal privilegeoperation;

    public String getPkPowerId() {
        return pkPowerId;
    }

    public void setPkPowerId(String pkPowerId) {
        this.pkPowerId = pkPowerId == null ? null : pkPowerId.trim();
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getPrivilegemaster() {
        return privilegemaster;
    }

    public void setPrivilegemaster(String privilegemaster) {
        this.privilegemaster = privilegemaster == null ? null : privilegemaster.trim();
    }

    public String getPrivilegemastervalue() {
        return privilegemastervalue;
    }

    public void setPrivilegemastervalue(String privilegemastervalue) {
        this.privilegemastervalue = privilegemastervalue == null ? null : privilegemastervalue.trim();
    }

    public String getPrivilegeaccess() {
        return privilegeaccess;
    }

    public void setPrivilegeaccess(String privilegeaccess) {
        this.privilegeaccess = privilegeaccess == null ? null : privilegeaccess.trim();
    }

    public String getPrivilegeaccessvalue() {
        return privilegeaccessvalue;
    }

    public void setPrivilegeaccessvalue(String privilegeaccessvalue) {
        this.privilegeaccessvalue = privilegeaccessvalue == null ? null : privilegeaccessvalue.trim();
    }

    public BigDecimal getPrivilegeoperation() {
        return privilegeoperation;
    }

    public void setPrivilegeoperation(BigDecimal privilegeoperation) {
        this.privilegeoperation = privilegeoperation;
    }
}