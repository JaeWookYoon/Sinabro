package com.sinabro.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class ProductVO {

	private String product_code="dd";
	private String brand;
	private String category;
	private String mainImg="gd";
	private String name;
	private List<Integer> quantitya;
	private List<String> sizeaa;
	private int price;
	private String sizea;
	private int quantity;
	private String optiona;
	private List<MultipartFile> imgFile;
	
	
	
	
	
	public String getOptiona() {
		return optiona;
	}
	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}
	public String getSizea() {
		return sizea;
	}
	public void setSizea(String sizea) {
		this.sizea = sizea;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<MultipartFile> getImgFile() {
		return imgFile;
	}
	public void setImgFile(List<MultipartFile> imgFile) {
		this.imgFile = imgFile;
	}


	
	
	public List<Integer> getQuantitya() {
		return quantitya;
	}
	public void setQuantitya(List<Integer> quantitya) {
		this.quantitya = quantitya;
	}
	public List<String> getSizeaa() {
		return sizeaa;
	}
	public void setSizeaa(List<String> sizeaa) {
		this.sizeaa = sizeaa;
	}
	
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMainImg() {
		return mainImg;
	}
	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductVO [product_code=" + product_code + ", brand=" + brand + ", category=" + category + ", mainImg="
				+ mainImg + ", name=" + name + ", quantitya=" + quantitya + ", sizeaa=" + sizeaa + ", price=" + price
				+ ", optiona=" + optiona + ", imgFile=" + imgFile + "]";
	}
	
	
}
