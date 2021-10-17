package com.mindtree.shoppingCartApplication.apiConfig;

public class ApiErrorResponse {
	private String message;
	private String httpStatus;
	private int httpStatusCode;
	private boolean success;
	private boolean error;
	private String exception;
	public ApiErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiErrorResponse(String message, String httpStatus, int httpStatusCode, boolean success, boolean error,
			String exception) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.httpStatusCode = httpStatusCode;
		this.success = success;
		this.error = error;
		this.exception = exception;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	public int getHttpStatusCode() {
		return httpStatusCode;
	}
	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	
}
