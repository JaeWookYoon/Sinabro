package com.sinabro.model;

import java.sql.Date;
import java.util.List;

public class PaymentListVO {

	private int num;
	private String id;
	private List<String> product_code;
	private Date datea;
	private List<Integer> price;
	private List<String> order_code;
	private List<String> status;
	private List<String> address;
	private List<String> order_message;
	
	private List<String> zipcode;
	private List<String> address1;
	private List<String> address2;
	
	private List<String> sizea;
	private List<Integer> milage;
	private String nameone;
	private int usemilage;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getProduct_code() {
		return product_code;
	}
	public void setProduct_code(List<String> product_code) {
		this.product_code = product_code;
	}
	public Date getDatea() {
		return datea;
	}
	public void setDatea(Date datea) {
		this.datea = datea;
	}
	public List<Integer> getPrice() {
		return price;
	}
	public void setPrice(List<Integer> price) {
		this.price = price;
	}
	public List<String> getOrder_code() {
		return order_code;
	}
	public void setOrder_code(List<String> order_code) {
		this.order_code = order_code;
	}
	public List<String> getStatus() {
		return status;
	}
	public void setStatus(List<String> status) {
		this.status = status;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public List<String> getOrder_message() {
		return order_message;
	}
	public void setOrder_message(List<String> order_message) {
		this.order_message = order_message;
	}
	public List<String> getZipcode() {
		return zipcode;
	}
	public void setZipcode(List<String> zipcode) {
		this.zipcode = zipcode;
	}
	public List<String> getAddress1() {
		return address1;
	}
	public void setAddress1(List<String> address1) {
		this.address1 = address1;
	}
	public List<String> getAddress2() {
		return address2;
	}
	public void setAddress2(List<String> address2) {
		this.address2 = address2;
	}
	public List<String> getSizea() {
		return sizea;
	}
	public void setSizea(List<String> sizea) {
		this.sizea = sizea;
	}
	public List<Integer> getMilage() {
		return milage;
	}
	public void setMilage(List<Integer> milage) {
		this.milage = milage;
	}
	public String getNameone() {
		return nameone;
	}
	public void setNameone(String nameone) {
		this.nameone = nameone;
	}
	public int getUsemilage() {
		return usemilage;
	}
	public void setUsemilage(int usemilage) {
		this.usemilage = usemilage;
	}
	
	
}
