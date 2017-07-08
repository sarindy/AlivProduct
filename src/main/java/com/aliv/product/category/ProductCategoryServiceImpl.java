package com.aliv.product.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliv.responsecode.ResponseCodeModel;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepo productCategoryRepo;

	@Override
	public ResponseCodeModel addProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseCodeModel getProductCategory(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub

	}

}
