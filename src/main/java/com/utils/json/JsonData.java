package com.utils.json;

public class JsonData extends JsonObject {
	private Object data;
	
	public JsonData() {}
	
	public JsonData(Object data) {
		this.data =  data;
		this.result = "success";
		this.code = 0;
		this.success = true;
	}
	
	public JsonData(Object data, Boolean success, String msg) {
        this.data =  data;
        this.result = msg;
        if(success != null || success) {
            this.code = 0;
        } else {
            this.code = -1;
        }
        this.success = success;
    }

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
