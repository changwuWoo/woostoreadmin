package org.edge.woostore.domain.exception;


import org.edge.woostore.domain.dto.FieldError;

import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */
public class ParamValidException extends Throwable {
    private final List<FieldError> fieldErrors;
    public ParamValidException(List<FieldError> errors) {
        this.fieldErrors = errors;
    }
}
