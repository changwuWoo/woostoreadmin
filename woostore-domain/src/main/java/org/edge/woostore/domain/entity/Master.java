package org.edge.woostore.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/4/28.
 */
@Entity
@Table(name = "TB_MASTER", schema = "WOOSTOREADMIN")
public class Master {
    private String pkId;
    @NotNull(message = "不能null")
    @Size(max = 23,min = 6,message = "length is  6-23")
    private String fname;
    private String fnumber;
    @NotNull(message = "不能null")
    private String fpassword;
    private BigDecimal fkStKey;

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
    @Column(name = "FNUMBER")
    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    @Basic
    @Column(name = "FPASSWORD")
    public String getFpassword() {
        return fpassword;
    }

    public void setFpassword(String fpassword) {
        this.fpassword = fpassword;
    }

    @Basic
    @Column(name = "FK_ST_KEY")
    public BigDecimal getFkStKey() {
        return fkStKey;
    }

    public void setFkStKey(BigDecimal fkStKey) {
        this.fkStKey = fkStKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Master that = (Master) o;

        if (pkId != null ? !pkId.equals(that.pkId) : that.pkId != null) return false;
        if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
        if (fnumber != null ? !fnumber.equals(that.fnumber) : that.fnumber != null) return false;
        if (fpassword != null ? !fpassword.equals(that.fpassword) : that.fpassword != null) return false;
        if (fkStKey != null ? !fkStKey.equals(that.fkStKey) : that.fkStKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkId != null ? pkId.hashCode() : 0;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (fnumber != null ? fnumber.hashCode() : 0);
        result = 31 * result + (fpassword != null ? fpassword.hashCode() : 0);
        result = 31 * result + (fkStKey != null ? fkStKey.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Master{" +
                "pkId='" + pkId + '\'' +
                ", fname='" + fname + '\'' +
                ", fnumber='" + fnumber + '\'' +
                ", fpassword='" + fpassword + '\'' +
                ", fkStKey=" + fkStKey +
                '}';
    }
}
