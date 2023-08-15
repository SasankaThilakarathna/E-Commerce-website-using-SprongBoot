package com.infinitefashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infinitefashion.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService service;
	
	@RequestMapping("/deleteMyCart/{id}")
	public String deleteMyCart(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/cart";
	}
}
