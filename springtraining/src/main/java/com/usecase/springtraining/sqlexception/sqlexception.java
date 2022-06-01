package com.usecase.springtraining.sqlexception;

public class sqlexception extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String error_msg;
	private final int error_code = 407;
	
	public sqlexception(String error_msg) {
		super();
		this.error_msg = error_msg;
	}
	public String getError_msg() {
		return error_msg;
	}
	public int getError_code() {
		return error_code;
	}
}
