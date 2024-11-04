package com.br.pessoas.infra.dataProvider.repository.impl;

import com.br.pessoas.infra.dataProvider.repository.TelephoneRepository;
import com.br.pessoas.infra.dataProvider.repository.model.TelephoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TelephoneRepositoryImpl {

	@Autowired @Lazy
	private TelephoneRepository repository;

	public TelephoneModel save(final TelephoneModel model) {
		return repository.save(model);
	}

	public List<TelephoneModel> findAllByPersonId(final Long personId) {
        return repository.findAllByPersonId(personId);
    }
}
