package org.edge.woostore.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/2.
 */
@Entity
@Table(name = "TB_CITY", schema = "WOOSTOREADMIN")
public class City {
    private String pkId;
    private String name;
    private String number;
    private String code;
    private String fkParentId;
    private City city = new City();
    private Collection<City> cityCollection = new ArrayList<>();

    @Transient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(Collection<City> cityCollection) {
        this.cityCollection = cityCollection;
    }

    @Transient
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "FKPARENTID")
    public String getFkParentId() {
        return fkParentId;
    }

    public void setFkParentId(String fkparentid) {
        this.fkParentId = fkparentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(pkId, city.pkId) &&
                Objects.equals(name, city.name) &&
                Objects.equals(number, city.number) &&
                Objects.equals(code, city.code) &&
                Objects.equals(fkParentId, city.fkParentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, name, number, code, fkParentId);
    }
}
