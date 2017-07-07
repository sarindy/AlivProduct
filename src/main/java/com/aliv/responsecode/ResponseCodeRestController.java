package com.aliv.responsecode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class ResponseCodeRestController {

	@Autowired
	private ResponseCodeServiceImpl responseCodeService;

	@Autowired
	private ResponseCodeModel responseCodeModelObj;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/api/addResponseCode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> addResponseCode(@RequestBody ResponseCodeModel responseCodeModel) {
		try {
			responseCodeService.addResponseCode(responseCodeModel);
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber();
			logger.error(error);
			logger.error(err.getMessage());
			return new ResponseEntity<String>("Bad", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/api/getResponseCode", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseCodeModel> getResponseCodeByCode(@RequestBody ResponseCodeModel responseCodeModel) {

		try {
			responseCodeModelObj = responseCodeService.getResponseCode(responseCodeModel.getCode());
			if (responseCodeModelObj != null) {
				return new ResponseEntity<ResponseCodeModel>(responseCodeModelObj, HttpStatus.OK);
			} else {
				return null;
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
