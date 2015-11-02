package com.utils.json;

public class JsonSuccess extends JsonObject {
	
	public JsonSuccess() {
		this("");
	}
	
	public JsonSuccess(String msg) {
		this.code = 0;
		this.message = msg;
		this.result = "success";
		this.success = true;
	}
}
