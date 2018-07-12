package org.woo.domain.exception;


import org.woo.domain.dto.FieldError;

import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */
public class ParamValidException extends Throwable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9119268085062439615L;
	private final List<FieldError> fieldErrors;
    public ParamValidException(List<FieldError> errors) {
        this.fieldErrors = errors;
    }
	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}
}
