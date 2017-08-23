package com.sinabro.manager.product.service;

import java.util.List;

import com.sinabro.model.BrandVO;
import com.sinabro.model.ProductVO;

public interface ManagerProductService {
	List<ProductVO> getProductList(Object param); 
	int getListCount(Object obj);
	List<BrandVO>getBrand();
	BrandVO getBrand(String brand);
	ProductVO getProductContent(String product_code);
	int updateProduct(ProductVO vo,String uploadPath);
	int deleteProduct(String product_code);
}
