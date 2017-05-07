/**
 * 
 */
package org.edge.woostore.domain.exception;

import java.text.MessageFormat;
import org.edge.woostore.domain.dto.ErrorInfo;

/** 
 * @ClassName: BusinessException 
 * @Description: TODO
 * @author Administrator 
 * @date 2017年3月10日 上午9:36:30 
 *  
 */
public class BusinessException extends Exception {

	
	
	/**
	  * <p> ErrorInfo ErrorInfo：异常对象</p>
	 */
	private ErrorInfo ErrorInfo;
	
	
	
	public BusinessException(ErrorInfo ErrorInfo) {
		super(ErrorInfo.getErrorMsg());
		this.ErrorInfo = ErrorInfo;
	}

	
	public BusinessException(ErrorInfo ErrorInfo,Object[] params){
		super(MessageFormat.format(ErrorInfo.getErrorMsg(), params));
		ErrorInfo.setErrorMsg(MessageFormat.format(ErrorInfo.getErrorMsg(), params));
		this.ErrorInfo = ErrorInfo;
	}

	
	
	/**
	 * @param string
	 */
	public BusinessException(String string) {
		// TODO Auto-generated constructor stub
	}


	public ErrorInfo getErrorInfo() {
		return ErrorInfo;
	}
	public void setErrorInfo(ErrorInfo ErrorInfo) {
		this.ErrorInfo = ErrorInfo;
	}
}
