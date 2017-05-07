package org.edge.woostore.domain.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/24.
 */
public class FieldError implements Serializable{
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
