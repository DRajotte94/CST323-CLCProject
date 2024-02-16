package com.app.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.webapp.data.ProductsDataAccessInterface;
import com.app.webapp.model.ProductModel;

public class ProductBusinessService implements ProductBusinessServiceInterface {
	
	@Autowired
	ProductsDataAccessInterface productsDAO;

	@Override
	public List<ProductModel> getProducts() {
		return productsDAO.getProducts();
	}

	@Override
	public List<ProductModel> searchProducts(String searchTerm) {
		return productsDAO.searchProducts(searchTerm);
	}

	@Override
	public ProductModel getById(int id) {
		return productsDAO.getById(id);
	}

	@Override
	public long addProduct(ProductModel newProduct) {
		return productsDAO.addProduct(newProduct);
	}

	@Override
	public ProductModel updateProduct(ProductModel updateProduct) {
		return productsDAO.updateProduct(updateProduct);
	}
	
	@Override
	public boolean deleteProduct(int id) {
		return productsDAO.deleteProduct(id);
	}

}
