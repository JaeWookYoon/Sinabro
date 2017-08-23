package com.sinabro.user.product.dao;

import java.util.List;

import com.sinabro.model.BrandVO;
import com.sinabro.model.ProductVO;

public interface ProductListDAO {
	List<ProductVO> getProductList(Object map);
	List<ProductVO> getProductListB(Object param);
	List<ProductVO> getProductListA(Object param);
	List<ProductVO> getProductListC(Object param);
	int getListCount();
	int getListCountBrand(Object obj);
	int getListCountCategory(Object obj);
	int getListCountBoth(Object obj);
	List<BrandVO>getBrand();
	BrandVO getBrand(String brand);
	ProductVO getProductContent(String product_code);
}
