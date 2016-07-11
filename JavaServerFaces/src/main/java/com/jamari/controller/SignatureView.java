package com.jamari.controller;
	
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SignatureView {
     
    private String value;
 
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }
}
