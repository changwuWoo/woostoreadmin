package org.edge.woostore.domain.dto;

public class ResultDTO {
	private static final String OK = "ok";
	private static final String ERROR = "error";
	public  static final String NO_THIS_USEERNAME="用户名不存在";
	public  static final String LOGIN_FAILD="用户名或者密码错误";
	public  static final String LOGIN_SUCCESS="登录成功";

	private Meta meta;
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ResultDTO success() {
		this.meta = new Meta(true, OK);
		return this;
	}

	public  ResultDTO success(String message) {
		this.meta = new Meta(true, OK);
		this.data =message;
		return this;
	}

	public ResultDTO failure() {
		this.meta = new Meta(false, ERROR);
		return this;
	}

	public ResultDTO failure(String message) {
		this.meta = new Meta(false, ERROR);
		this.data =message;
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