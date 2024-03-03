package com.app.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logInfo = LoggerFactory.getLogger(ProductsController.class);

	@GetMapping("/")
	public String showAllProducts(Model model) {		
		try {
			List<ProductModel> products = service.getProducts();
			model.addAttribute("products", products);
			logInfo.info("Product info logging is enabled");
			return "products";
		} catch (Exception error) {
			logInfo.error(error.toString());
			return "error";
		}
		
	}
	
	@GetMapping("/{searchId}")
	public String searchById(Model model, @PathVariable(name="searchId") int searchId) {
		try {
			ProductModel products = service.getById(searchId);
			model.addAttribute("products", products);
			return "products";
		} catch (Exception error) {
			logInfo.error(error.toString());
			return "error";
		}
	}
	
	@GetMapping("/search/{searchTerm}")
	public String searchProducts(Model model, @PathVariable(name="searchTerm") String searchTerm) {
		try {
			List<ProductModel> products = service.searchProducts(searchTerm);
			model.addAttribute("products", products);
			return "products";
		} catch (Exception error) {
			logInfo.error(error.toString());
			return "error";
		}
	}
	
	@GetMapping("/create")
	public String createProduct(Model model) {
		try {
			model.addAttribute("productModel", new ProductModel());
			return "create";
		} catch (Exception error) {
			logInfo.error(error.toString());
			return "error";
		}
		
	}
	
	@PostMapping("/create/process")
	public String addProduct(ProductModel model) {
		try {
			logInfo.info("Added product number: " + service.addProduct(model));
			return "confirm";
		} catch (Exception error) {
			logInfo.error(error.toString());
			return "error";
		}
		
	}
	
	@GetMapping("/update/{id}")
	public String updateProduct(Model model, @PathVariable(name="id") int id) {
		try {
			model.addAttribute("productModel", service.getById(id));
			return "edit";
		} catch (Exception error) {
			logInfo.error(error.toString());
			return "error";
		}
		
	}
	
	@PutMapping("/update/process")
	public String update(ProductModel model) {
		try {
			logInfo.info(service.updateProduct(model).toString());
			return "confirm";
		} catch (Exception error) {
			logInfo.error(error.toString());
			return "error";
		}
		
	}
	
	// Delete from products
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") int id) {
		try {
			logInfo.info("Deleted product number: " + id + " " + service.deleteProduct(id));
			return "confirm";
		} catch (Exception error) {
			logInfo.error(error.toString());
			return "error";
		}
		
	}

}
