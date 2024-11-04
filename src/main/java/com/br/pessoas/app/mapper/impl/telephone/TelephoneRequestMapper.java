package com.br.pessoas.app.mapper.impl.telephone;

import com.br.pessoas.app.dto.TelephoneRequest;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.TelephoneEntity;
import org.springframework.stereotype.Component;

@Component
public class TelephoneRequestMapper implements Mapper<TelephoneEntity, TelephoneRequest> {

	@Override
	public TelephoneEntity mapperToTarget(TelephoneRequest request) {
		return new TelephoneEntity(request.getStateCode(), request.getPhoneNumber(),request.getPersonId(), request.getId(), request.getCountryCode());
	}

	@Override
	public TelephoneRequest mapperToSource(TelephoneEntity entity) {
		return new TelephoneRequest(entity.getId(), entity.getPersonId(), entity.getPhoneNumber(), entity.getStateCode(), entity.getCountryCode());
	}
}
