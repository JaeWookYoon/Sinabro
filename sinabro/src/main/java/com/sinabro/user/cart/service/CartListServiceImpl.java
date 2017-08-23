package com.sinabro.user.cart.service;

import java.util.List;

import com.sinabro.model.CartVO;
import com.sinabro.model.ProductVO;
import com.sinabro.user.cart.dao.CartListDAO;

public class CartListServiceImpl implements CartListService{

	private CartListDAO cartDAO;
	
	public void setCartDAO(CartListDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	@Override
	public ProductVO getCartList(String product_code) {
		// TODO Auto-generated method stub
		return cartDAO.getCartList(product_code);
	}

	@Override
	public int insertCart(CartVO cart) {
		// TODO Auto-generated method stub
		return cartDAO.insertCart(cart);
	}

	@Override
	public List<CartVO> getCart(String id) {
		// TODO Auto-generated method stub
		return cartDAO.getCart(id);
	}

	@Override
	public int deleteCart(Object obj) {
		// TODO Auto-generated method stub
		return cartDAO.deleteCart(obj);
	}
	
	

}
