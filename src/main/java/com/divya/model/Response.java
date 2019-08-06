package com.divya.model;

public class Response {

	private String w;
	private int n;

	public Response(String w, int n) {
		this.w = w;
		this.n = n;
	}
	
	public Response () {}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getW() {
		return w;
	}

	public void setW(String w) {
		this.w = w;
	}
}
