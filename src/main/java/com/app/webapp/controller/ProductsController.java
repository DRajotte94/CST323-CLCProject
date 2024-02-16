package com.app.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.webapp.model.ProductModel;
import com.app.webapp.services.ProductBusinessServiceInterface;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	ProductBusinessServiceInterface service;

	@GetMapping("/")
	public String showAllProducts(Model model) {		
		List<ProductModel> products = service.getProducts();
		model.addAttribute("products", products);		
		return "products";
	}
	
	@GetMapping("/{searchId}")
	public String searchById(Model model, @PathVariable(name="searchId") int searchId) {
		ProductModel products = service.getById(searchId);
		model.addAttribute("products", products);
		return "products";
	}
	
	@GetMapping("/search/{searchTerm}")
	public String searchProducts(Model model, @PathVariable(name="searchTerm") String searchTerm) {
		List<ProductModel> products = service.searchProducts(searchTerm);
		model.addAttribute("products", products);
		return "products";
	}
	
	@GetMapping("/create")
	public String createProduct(Model model) {
		model.addAttribute("productModel", new ProductModel());
		return "create";
	}
	
	@PostMapping("/create/process")
	public String addProduct(ProductModel model) {
		System.out.println("Added product number: " + service.addProduct(model));
		return "confirm";
	}
	
	@GetMapping("/update/{id}")
	public String updateProduct(Model model, @PathVariable(name="id") int id) {
		model.addAttribute("productModel", service.getById(id));
		return "edit";
	}
	
	@PutMapping("/update/process")
	public String update(ProductModel model) {
		System.out.println(service.updateProduct(model));
		return "confirm";
	}
	
	// Delete from products
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") int id) {
		System.out.println("Deleted product number: " + id + " " + service.deleteProduct(id));
		return "confirm";
	}

}
