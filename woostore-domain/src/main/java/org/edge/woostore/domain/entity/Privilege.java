package org.edge.woostore.domain.entity;

/**
 * Created by Administrator on 2017/3/29.
 */
public class Privilege {
    private String value;

    public Privilege(String value) {
        this.value = value;
    }

    public Privilege() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
