package com.utils.json;

import java.util.Date;

public class JsonObject {
	protected String result;
	protected Integer code;
	protected String message;
	protected boolean success;
	protected Date timestamp = new Date();
	
	public JsonObject() {}
	
	public JsonObject(Boolean success,String msg) {
		this.code = 0;
		this.message = msg;
		this.result = "success";
	}
	
	@Deprecated
	public String getResult() {
		return result;
	}
	@Deprecated
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
