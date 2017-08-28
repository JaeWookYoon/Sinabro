package com.sinabro.model;

import java.sql.Date;
import java.util.List;

public class PaymentVO {

	
	private int num;
	private String id;
	private Date datea;
	private String order_code;
	private String status;
	private String address;
	private String order_message;
	
	
	private String product_code;
	private String sizea;
	private int price;
	private double milage;
	private int total;
	
	private String zipcode;
	private String address1;
	private String address2;
	private List<String>product_codea;
	private List<String>sizeaa;
	private List<Integer>pricea;
	private List<Double>milagea;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	private String nameone;
	private int usemilage;
	
	
	public String getNameone() {
		return nameone;
	}
	public void setNameone(String nameone) {
		this.nameone = nameone;
	}
	
	public PaymentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getUsemilage() {
		return usemilage;
	}
	public void setUsemilage(int usemilage) {
		this.usemilage = usemilage;
	}
	public String getSizea() {
		return sizea;
	}
	public void setSizea(String sizea) {
		this.sizea = sizea;
	}
	
	public void setMilage(int milage) {
		this.milage = milage;
	}
	
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
	public List<Integer> getPricea() {
		return pricea;
	}
	public void setPricea(List<Integer> pricea) {
		this.pricea = pricea;
	}
	
	public double getMilage() {
		return milage;
	}
	public void setMilage(double milage) {
		this.milage = milage;
	}
	public List<Double> getMilagea() {
		return milagea;
	}
	public void setMilagea(List<Double> milagea) {
		this.milagea = milagea;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrder_message() {
		return order_message;
	}
	public void setOrder_message(String order_message) {
		this.order_message = order_message;
	}
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
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public Date getDatea() {
		return datea;
	}
	public void setDatea(Date datea) {
		this.datea = datea;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	
	
}
