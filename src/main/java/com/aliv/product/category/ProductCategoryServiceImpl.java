package com.aliv.product.category;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepo productCategoryRepo;

	@Autowired
	private ProductCategory productCategoryModel;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ProductCategory addProductCategory(ProductCategory productCategory) {

		try {

			productCategoryModel = productCategoryRepo.findByPCatCode(productCategory.getpCatCode());
			if (productCategoryModel == null) {
				productCategory.setLastModifiedDate(new Date());
				productCategoryRepo.save(productCategory);
				return productCategory;
			} else {
				return null;
			}

		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber() + "Error Message : " + err.getMessage();
			logger.error(error);
			return null;
		}

	}

	@Override
	public ProductCategory getProductCategory(String code) {
		try {
			productCategoryModel = productCategoryRepo.findByPCatCode(code);
			if (productCategoryModel != null) {

				return productCategoryModel;
			} else {
				return null;
			}

		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber() + "Error Message : " + err.getMessage();
			logger.error(error);
			return null;
		}
	}

	@Override
	public void deleteProductCategory(ProductCategory productCategory) {
		try {
			
			

		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber() + "Error Message : " + err.getMessage();
			logger.error(error);

		}

	}

	@Override
	public void updateProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub

	}

}
