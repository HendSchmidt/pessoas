package com.br.pessoas.infra.dataProvider.repository.impl;

import com.br.pessoas.infra.dataProvider.repository.TelephoneRepository;
import com.br.pessoas.infra.dataProvider.repository.model.TelephoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TelephoneRepositoryImpl {

	@Autowired
	@Lazy
	private TelephoneRepository repository;

	public TelephoneModel save(final TelephoneModel model) {
		return repository.save(model);
	}

	public List<TelephoneModel> findAll(final Long personId) {
		TelephoneModel model = new TelephoneModel();
		model.setPersonId(personId);
		Example<TelephoneModel> example = Example.of(model);

		return repository.findAll(example, Sort.by(Sort.Order.asc("countryCode")));
	}
}
