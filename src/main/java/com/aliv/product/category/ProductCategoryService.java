package com.aliv.product.category;

import com.aliv.responsecode.ResponseCodeModel;

public interface ProductCategoryService {

	public ProductCategory addProductCategory(ProductCategory productCategory);

	public ProductCategory getProductCategory(String code);

	public void deleteProductCategory(ProductCategory productCategory);

	public void updateProductCategory(ProductCategory productCategory);
}
