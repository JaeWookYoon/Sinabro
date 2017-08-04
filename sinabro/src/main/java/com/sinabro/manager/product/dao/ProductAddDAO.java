package com.sinabro.manager.product.dao;

import com.sinabro.model.ProductVO;

public interface ProductAddDAO {

	int addProduct(ProductVO vo);
	int checkBrand(String brand);
	int newProductCode(String product_code);
	int insertBrand(String brand);
	
	int img_SEQ();
}
