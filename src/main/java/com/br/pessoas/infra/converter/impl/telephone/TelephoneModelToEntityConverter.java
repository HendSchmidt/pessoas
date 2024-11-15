package com.br.pessoas.infra.converter.impl.telephone;

import com.br.pessoas.domain.entity.TelephoneEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.TelephoneModel;

public class TelephoneModelToEntityConverter implements Converter<TelephoneEntity, TelephoneModel> {
	@Override
	public TelephoneEntity convert(TelephoneModel model) {
		return new TelephoneEntity(model.getStateCode(), model.getPhoneNumber(), model.getPersonId(), model.getId(), model.getCountryCode(), model.getDescription());
	}
}
