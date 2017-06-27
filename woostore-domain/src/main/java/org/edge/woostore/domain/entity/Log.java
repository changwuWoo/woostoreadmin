package org.edge.woostore.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Administrator on 2017/6/5.
 */
@Entity
@Table(name = "TB_LOG", schema = "WOOSTOREADMIN")
public class Log implements Serializable{
    private String pkId;
    private String pkMasterName;
    private String ftablename;
    private String foptype;
    private String fcontent;
    private Timestamp foptime;
    private boolean fmaintaintime;
    private String fparams;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "PK_MASTER_NAME")
    public String getPkMasterName() {
        return pkMasterName;
    }

    public void setPkMasterName(String pkMasterName) {
        this.pkMasterName = pkMasterName;
    }

    @Basic
    @Column(name = "FTABLENAME")
    public String getFtablename() {
        return ftablename;
    }

    public void setFtablename(String ftablename) {
        this.ftablename = ftablename;
    }

    @Basic
    @Column(name = "FOPTYPE")
    public String getFoptype() {
        return foptype;
    }

    public void setFoptype(String foptype) {
        this.foptype = foptype;
    }

    @Basic
    @Column(name = "FCONTENT")
    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent;
    }

    @Basic
    @Column(name = "FOPTIME")
    public Timestamp getFoptime() {
        return foptime;
    }

    public void setFoptime(Timestamp foptime) {
        this.foptime = foptime;
    }

    @Basic
    @Column(name = "FMAINTAINTIME")
    public boolean isFmaintaintime() {
        return fmaintaintime;
    }

    public void setFmaintaintime(boolean fmaintaintime) {
        this.fmaintaintime = fmaintaintime;
    }

    @Basic
    @Column(name = "FPARAMS")
    public String getFparams() {
        return fparams;
    }

    public void setFparams(String fparams) {
        this.fparams = fparams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return fmaintaintime == log.fmaintaintime &&
                Objects.equals(pkId, log.pkId) &&
                Objects.equals(pkMasterName, log.pkMasterName) &&
                Objects.equals(ftablename, log.ftablename) &&
                Objects.equals(foptype, log.foptype) &&
                Objects.equals(fcontent, log.fcontent) &&
                Objects.equals(foptime, log.foptime) &&
                Objects.equals(fparams, log.fparams);
    }

    @Override
    public String toString() {
        return "Log{" +
                "pkId='" + pkId + '\'' +
                ", pkMasterName='" + pkMasterName + '\'' +
                ", ftablename='" + ftablename + '\'' +
                ", foptype='" + foptype + '\'' +
                ", fcontent='" + fcontent + '\'' +
                ", foptime=" + foptime +
                ", fmaintaintime=" + fmaintaintime +
                ", fparams='" + fparams + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, pkMasterName, ftablename, foptype, fcontent, foptime, fmaintaintime, fparams);
    }
}
