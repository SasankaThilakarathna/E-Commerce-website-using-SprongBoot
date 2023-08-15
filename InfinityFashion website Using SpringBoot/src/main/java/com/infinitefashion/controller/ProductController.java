package com.infinitefashion.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.infinitefashion.model.Cart;
import com.infinitefashion.model.Product;
import com.infinitefashion.service.CartService;
import com.infinitefashion.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/home")
	public String Home() {
		return "home";
	}
	
	@GetMapping("/admin")
	public String Admin() {
		return "admin";
	}
	
	@GetMapping("/productList")
	public ModelAndView AvailableProducts() {
		List<Product>list=service.getAllProduct();
	//	ModelAndView m=new ModelAndView();
	//	m.setViewName("productList");
	//	m.addObject("book,list");
		return new ModelAndView("productList", "product", list);
	}
	
	@PostMapping("/save")
	public String addProduct(@ModelAttribute Product p) {
		service.save(p);
		return "redirect:/productList";
	}
	
	@GetMapping("/cart")
		public String getCart(Model model) {   
			List<Cart>list=cartService.getAllMyProducts();
			model.addAttribute("product",list);
			return "cart";
		}
	
	@RequestMapping("/mycart/{id}")
	public String getCartList(@PathVariable("id") int id) {
		Product p=service.getProductById(id);
		Cart mc=new Cart (p.getId(),p.getProductName(),p.getDescription(),p.getPrice());
		cartService.saveMyProduct(mc);
		return "redirect:/cart"; 
	}
	
	@RequestMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id,Model model) {
		Product p=service.getProductById(id);
		model.addAttribute("product",p);
		return "productEdit";
	}
	
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/productList";
	}
	
	
}
