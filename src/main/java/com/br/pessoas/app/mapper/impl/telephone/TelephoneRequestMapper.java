package com.br.pessoas.app.mapper.impl.telephone;

import com.br.pessoas.app.dto.TelephoneRequest;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.TelephoneEntity;
import org.springframework.stereotype.Component;

@Component
public class TelephoneRequestMapper implements Mapper<TelephoneEntity, TelephoneRequest> {

	@Override
	public TelephoneEntity mapperToTarget(TelephoneRequest request) {
		return new TelephoneEntity(request.getStateCode(), request.getPhoneNumber(), request.getId(), request.getCountryCode(), request.getDescription());
	}

	@Override
	public TelephoneRequest mapperToSource(TelephoneEntity entity) {
		return new TelephoneRequest(entity.getId(), entity.getPhoneNumber(), entity.getStateCode(), entity.getCountryCode(), entity.getDescription());
	}
}
