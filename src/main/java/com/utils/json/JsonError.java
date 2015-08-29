package com.utils.json;

public class JsonError extends JsonObject {
	
	public JsonError() {}
	
	
	public JsonError(String msg) {
		this(msg,-1);
	}
	
	public JsonError(String msg,Integer code) {
		this.code = code;
		this.message = msg;
		this.result = "fail";
		this.success = false;
	}
}
