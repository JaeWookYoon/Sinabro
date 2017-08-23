package com.sinabro.user.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sinabro.model.BrandVO;
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
			
			return productDAO.getProductList(map);
		}if(!map.get("brand").equals("ALL")&&map.get("category").equals("ALL")) {
			return productDAO.getProductListA(param);
		}if(map.get("brand").equals("ALL")&&!map.get("category").equals("ALL")) {
			return productDAO.getProductListC(param);
		}
		
		else {
			return productDAO.getProductListB(param);
		}
			
	}



	@Override
	public int getListCount(Object obj) {
		// TODO Auto-generated method stub
		Map<String,Object> map=(Map)obj;
if(map.get("brand").equals("ALL")&&map.get("category").equals("ALL")) {
			
			return productDAO.getListCount();
		}if(!map.get("brand").equals("ALL")&&map.get("category").equals("ALL")) {
			return productDAO.getListCountBrand(obj);
		}if(map.get("brand").equals("ALL")&&!map.get("category").equals("ALL")) {
			return productDAO.getListCountCategory(obj);
		}
		
		else {
			return productDAO.getListCountBoth(obj);
		}
			
		
	}



	@Override
	public List<BrandVO> getBrand() {
		// TODO Auto-generated method stub
		return productDAO.getBrand();
	}



	@Override
	public ProductVO getProductContent(String product_code) {
		// TODO Auto-generated method stub
		return productDAO.getProductContent(product_code);
	}



	@Override
	public BrandVO getBrand(String brand) {
		// TODO Auto-generated method stub
		return productDAO.getBrand(brand);
	}

}
