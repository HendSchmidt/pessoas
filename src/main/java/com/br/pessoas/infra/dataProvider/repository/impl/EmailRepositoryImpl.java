package com.br.pessoas.infra.dataProvider.repository.impl;

import com.br.pessoas.infra.dataProvider.repository.EmailRepository;
import com.br.pessoas.infra.dataProvider.repository.model.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailRepositoryImpl {

	@Autowired @Lazy
	private EmailRepository repository;

	public EmailModel save(final EmailModel model) {
		return repository.save(model);
	}

	public List<EmailModel> findAllByPersonId(final Long personId) {
		return repository.findAllByPersonId(personId);
	}
}
