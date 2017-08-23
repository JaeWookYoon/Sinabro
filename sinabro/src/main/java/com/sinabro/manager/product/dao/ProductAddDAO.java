package com.sinabro.manager.product.dao;

import java.util.List;

import com.sinabro.model.BrandVO;
import com.sinabro.model.ProductVO;

public interface ProductAddDAO {

	int addProduct(ProductVO vo);
	int checkBrand(String brand);
	List<BrandVO> getBrand();
	int insertBrand(BrandVO vo);
	int updateBrand(BrandVO vo);
	int deleteBrand(String brand);
	
	int img_SEQ();
}
