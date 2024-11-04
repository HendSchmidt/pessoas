package com.br.pessoas.app.mapper.impl.telephone;

import com.br.pessoas.app.dto.TelephoneResponse;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.TelephoneEntity;
import org.springframework.stereotype.Component;

@Component
public class TelephoneResponseMapper implements Mapper<TelephoneEntity, TelephoneResponse> {
	@Override
	public TelephoneEntity mapperToTarget(TelephoneResponse response) {
		return new TelephoneEntity(response.getStateCode(), response.getPhoneNumber(),response.getPersonId(), response.getId(), response.getCountryCode());

	}

	@Override
	public TelephoneResponse mapperToSource(TelephoneEntity entity) {
		return new TelephoneResponse (entity.getId(), entity.getPersonId(), entity.getPhoneNumber(), entity.getStateCode(), entity.getCountryCode());
	}
}
