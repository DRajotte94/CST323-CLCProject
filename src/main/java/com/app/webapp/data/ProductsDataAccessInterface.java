package com.app.webapp.data;

import java.util.List;

import com.app.webapp.model.ProductModel;

public interface ProductsDataAccessInterface {
	
	public ProductModel getById(int id);
	public List<ProductModel> getProducts();
	public List<ProductModel> searchProducts(String searchTerm);
	public long addProduct(ProductModel newProduct);
	public boolean deleteProduct(int id);
	public ProductModel updateProduct(ProductModel updateProduct);

}
