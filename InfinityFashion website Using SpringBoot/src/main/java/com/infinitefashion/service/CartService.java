package com.infinitefashion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinitefashion.model.Cart;
import com.infinitefashion.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cart;
	
	public void saveMyProduct(Cart c) {
		cart.save(c);
	}
	
	public List<Cart> getAllMyProducts(){
		return cart.findAll();
	}
	
	public void deleteById(int id) {
		cart.deleteById(id);
	}
}
