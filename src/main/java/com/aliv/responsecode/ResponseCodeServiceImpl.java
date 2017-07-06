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
			logger.error(err.getMessage());
			return "1";
		}

	}

	public ResponseCodeModel getResponseCode(String code) {
		try {
			return responseCodeRepo.findByCode(code);
		} catch (Exception err) {
			logger.error(err.getMessage());
			return null;
		}

	}

}
