package com.usecase.springtraining.objects;

public class client_det {
	
  private int c_id;
  private String name;
  private String token;

  public int getC_id() {
	return c_id;
}

  public void setC_id(int c_id) {
	this.c_id = c_id;
}

  public String getName() {
	return name;
}

  public void setName(String name) {
	this.name = name;
}

  public String getToken() {
	return token;
}

  public void setToken(String token) {
	this.token = token;
}


  public client_det() {
	super();
	// TODO Auto-generated constructor stub
}


  public client_det(int c_id, String name, String token) {
	super();
	this.c_id = c_id;
	this.name = name;
	this.token = token;
}


  @Override
  public String toString() {
	return "client_det [c_id=" + c_id + ", name=" + name + ", token=" + token + "]";
}
  
  
}
