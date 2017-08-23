package com.sinabro.user.cart.service;

import java.util.List;

import com.sinabro.model.CartVO;
import com.sinabro.model.ProductVO;

public interface CartListService {
	ProductVO getCartList(String product_code);
	int insertCart(CartVO cart);
	List<CartVO> getCart(String id);
	int deleteCart(Object obj);
}
