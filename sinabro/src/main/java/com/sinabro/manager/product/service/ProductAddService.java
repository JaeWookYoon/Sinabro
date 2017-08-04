package com.sinabro.manager.product.service;

import com.sinabro.model.ProductVO;

public interface ProductAddService {
	boolean checkBrand(String brand);
	int addProduct(ProductVO vo,String uploadPath);
	int newProductCode(String product_code);
	int insertBrand(String brand);
}
