package com.sinabro.manager.product.service;


import com.sinabro.model.BrandVO;
import com.sinabro.model.ProductVO;

public interface ProductAddService {
	boolean checkBrand(String brand);
	int addProduct(ProductVO vo,String uploadPath);
	java.util.List<BrandVO> getBrand();
	int insertBrand(BrandVO vo,String uploadPath);
	int updateBrand(BrandVO vo,String uploadPath);
	int deleteBrand(String brand);
}
