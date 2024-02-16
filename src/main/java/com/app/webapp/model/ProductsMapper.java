package com.app.webapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsMapper implements RowMapper<ProductModel> {

	@Override
	public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProductModel product = new ProductModel(
				rs.getInt("game_id"), 
				rs.getString("title"),
				rs.getString("genre"), 
				rs.getString("description"),
				rs.getString("age_rating"),
				rs.getDouble("price")
			);
		
		return product;
	}

}
