package org.woo.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/2.
 */
@Entity
@Table(name = "TB_GOODS", schema = "WOOSTOREADMIN")
public class Goods implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2342305611011667881L;
	private String pkId;
    private String name;
    private String number;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "FNUMBER")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(pkId, goods.pkId) &&
                Objects.equals(name, goods.name) &&
                Objects.equals(number, goods.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, name, number);
    }
}
