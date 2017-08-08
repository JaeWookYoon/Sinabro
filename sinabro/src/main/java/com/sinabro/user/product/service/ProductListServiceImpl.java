package com.sinabro.user.product.service;

import java.util.List;
import java.util.Map;

import com.sinabro.model.ProductVO;
import com.sinabro.user.product.dao.ProductListDAO;

public class ProductListServiceImpl implements ProductListService{

	private ProductListDAO productDAO;
	
	public void setProductDAO(ProductListDAO productDAO) {
		this.productDAO = productDAO;
	}

	

	@Override
	public List<ProductVO> getProductList(Object param) {
		// TODO Auto-generated method stub
		Map<String,Object>map=(Map<String,Object>)param;
		if(map.get("brand").equals("ALL")&&map.get("category").equals("ALL")) {
			return productDAO.getProductList();
		}else {
			return productDAO.getProductList(param);
		}
			
	}

}
