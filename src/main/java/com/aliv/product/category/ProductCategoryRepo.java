package com.aliv.product.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepo extends CrudRepository<ProductCategory, Long> {
	
	public ProductCategory findByPCatCode(String code);
	public ProductCategory findByName(String name);
	

}
