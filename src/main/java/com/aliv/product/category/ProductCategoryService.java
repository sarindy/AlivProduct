package com.aliv.product.category;

import com.aliv.responsecode.ResponseCodeModel;

public interface ProductCategoryService {

	public ResponseCodeModel addProductCategory(ProductCategory productCategory);

	public ResponseCodeModel getProductCategory(String code);

	public void deleteProductCategory(ProductCategory productCategory);

	public void updateProductCategory(ProductCategory productCategory);
}
