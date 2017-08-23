package com.sinabro.user.product.service;

import java.util.List;

import com.sinabro.model.BrandVO;
import com.sinabro.model.ProductVO;

public interface ProductListService {

	
	List<ProductVO> getProductList(Object param); 
	int getListCount(Object obj);
	List<BrandVO>getBrand();
	BrandVO getBrand(String brand);
	ProductVO getProductContent(String product_code);
}
