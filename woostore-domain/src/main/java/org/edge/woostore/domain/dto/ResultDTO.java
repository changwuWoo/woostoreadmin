package org.edge.woostore.domain.dto;

public class ResultDTO {
	private static final String OK = "ok";
	private static final String ERROR = "error";
	/**
	 * 数据请求返回码
	 */
	public static final int RESCODE_SUCCESS = 1000;				//成功
	public static final int RESCODE_SUCCESS_MSG = 1001;			//成功(有返回信息)
	public static final int RESCODE_EXCEPTION = 1002;			//请求抛出异常
	public static final int RESCODE_NOLOGIN = 1003;				//未登陆状态
	public static final int RESCODE_NOEXIST = 1004;				//查询结果为空
	public static final int RESCODE_NOAUTH = 1005;				//无操作权限
	public  static final String NO_THIS_USEERNAME="用户名不存在";
	public  static final String LOGIN_FAILD="用户名或者密码错误";
	public  static final String LOGIN_SUCCESS="登录成功";

	private Meta meta;
	private int code;
	private String data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ResultDTO success(int code) {
		this.meta = new Meta(true, OK);
		this.code =code;
		return this;
	}

	public  ResultDTO success(String message,int code) {
		this.meta = new Meta(true, OK);
		this.data =message;
		this.code =code;
		return this;
	}

	public ResultDTO failure(int code) {
		this.meta = new Meta(false, ERROR);
		this.code =code;
		return this;
	}

	public ResultDTO failure(String message,int code) {
		this.meta = new Meta(false, ERROR);
		this.data =message;
		this.code =code;
		return this;
	}

	public Meta getMeta() {
		return meta;
	}




    public class Meta {

		private boolean success;
		private String message;

		public Meta(boolean success) {
			this.success = success;
		}

		public Meta(boolean success, String message) {
			this.success = success;
			this.message = message;
		}

		public boolean isSuccess() {
			return success;
		}

		public String getMessage() {
			return message;
		}

		@Override
		public String toString() {
			return "Meta{" +
					"success=" + success +
					", message='" + message + '\'' +
					'}';
		}
	}

	@Override
	public String toString() {
		return "ResultDTO{" +
				"meta=" + meta +
				", data='" + data + '\'' +
				'}';
	}
}