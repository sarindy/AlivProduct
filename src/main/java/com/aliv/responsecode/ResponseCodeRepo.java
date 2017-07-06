package com.aliv.responsecode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseCodeRepo extends CrudRepository<ResponseCodeModel, Long> {

	public ResponseCodeModel findByCode(String code);

}
