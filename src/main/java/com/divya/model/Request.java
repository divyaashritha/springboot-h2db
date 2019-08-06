package com.divya.model;

public class Request {

    private String para;

    public Request(String para) {
        this.para = para;
    }
    
    public Request () {}

    public String getPara() {
        return para;
    }

	public void setPara(String para) {
		this.para = para;
	}
}
