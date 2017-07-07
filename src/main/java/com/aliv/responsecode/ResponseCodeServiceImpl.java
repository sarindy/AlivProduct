package com.aliv.responsecode;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseCodeServiceImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ResponseCodeRepo responseCodeRepo;

	@Autowired
	private ResponseCodeModel reponseCodeModelObj;

	public String addResponseCode(ResponseCodeModel responseCodeModel) {
		try {
			if (responseCodeRepo.findByCode(responseCodeModel.getCode().toString()) == null) {
				responseCodeModel.setLastModifiedDate(new Date());
				responseCodeRepo.save(responseCodeModel);
				logger.info("ResposeCode created");
				return "0";
			} else {
				logger.info("ResposeCode already exist");
				return "Code already exist";
			}
		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber();
			logger.error(error);
			logger.error(err.getMessage());
			return "1";
		}

	}

	public ResponseCodeModel getResponseCode(String code) {
		try {
			return responseCodeRepo.findByCode(code);
		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber();
			logger.error(error);
			logger.error(err.getMessage());
			return null;
		}

	}

	public ResponseCodeModel updateResponseCode(String code, ResponseCodeModel responseCodeModel) {
		try {
			reponseCodeModelObj = responseCodeRepo.findByCode(code);
			if (reponseCodeModelObj == null) {
				logger.info("Code not found");
				return null;

			} else {

				if (responseCodeModel != null) {
					reponseCodeModelObj.setLastModifiedDate(new Date());
				}

				if (responseCodeModel.getCode() != null) {
					reponseCodeModelObj.setCode(responseCodeModel.getCode());
				}
				if (responseCodeModel.getDescription() != null) {
					reponseCodeModelObj.setDescription(responseCodeModel.getDescription());
				}

				responseCodeRepo.save(reponseCodeModelObj);
				return reponseCodeModelObj;

			}

		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber();
			logger.error(error);
			logger.error(err.getMessage());
			return null;
		}
	}

}
