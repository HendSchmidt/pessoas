package com.br.pessoas.infra.converter.impl.telephone;

import com.br.pessoas.domain.entity.TelephoneEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.TelephoneModel;

public class TelephoneEntityToModelConverter implements Converter<TelephoneModel, TelephoneEntity> {
	@Override
	public TelephoneModel convert(TelephoneEntity entity) {
		return new TelephoneModel(entity.getPersonId(), entity.getCountryCode(), entity.getStateCode(), entity.getPhoneNumber(), entity.getDescription());
	}
}
