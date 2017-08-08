package com.sinabro.user.product.dao;

import java.util.List;

import com.sinabro.model.ProductVO;

public interface ProductListDAO {
	List<ProductVO> getProductList();
	List<ProductVO> getProductList(Object param);
}
