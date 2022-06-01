package com.usecase.springtraining.objects;

public class servresponse {
   
	private String resp_code;
	private String message;
	public String getResp_code() {
		return resp_code;
	}
	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "servresponse [resp_code=" + resp_code + ", message=" + message + "]";
	}
	public servresponse(String resp_code, String message) {
		super();
		this.resp_code = resp_code;
		this.message = message;
	}
	public servresponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
