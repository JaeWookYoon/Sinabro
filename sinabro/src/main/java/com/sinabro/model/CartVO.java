package com.sinabro.model;

import java.util.List;

public class CartVO {

	private String id;
	private String product_code;
	private String sizea;
	private List<String> product_codea;
	private List<String> sizeaa;
	
	
	
	
	public List<String> getProduct_codea() {
		return product_codea;
	}
	public void setProduct_codea(List<String> product_codea) {
		this.product_codea = product_codea;
	}
	public List<String> getSizeaa() {
		return sizeaa;
	}
	public void setSizeaa(List<String> sizeaa) {
		this.sizeaa = sizeaa;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getSizea() {
		return sizea;
	}
	public void setSizea(String sizea) {
		this.sizea = sizea;
	}
}
