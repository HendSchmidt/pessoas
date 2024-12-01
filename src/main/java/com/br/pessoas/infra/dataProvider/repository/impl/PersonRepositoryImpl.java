package com.br.pessoas.infra.dataProvider.repository.impl;

import com.br.pessoas.infra.dataProvider.repository.PersonRepository;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import com.br.pessoas.useCase.exception.PersonRecoveryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonRepositoryImpl {
	@Autowired
	@Lazy
	private PersonRepository repository;

	public PersonModel save(PersonModel source) {
		return repository.save(source);
	}

	public PersonModel update(PersonModel source) {
		return repository.save(source);
	}

	public void delete(final Long id) {
        repository.deleteById(id);
    }

	public PersonModel find(Long id) {
		return repository.findById(id).orElseThrow(() -> new PersonRecoveryException("Pessoa não encontrada."));
	}

	public List<PersonModel> findAllPerson() {
		return repository.findAll();
	}

	public Optional<PersonModel> findByCpf(final String cpf) {
		final PersonModel personModel = new PersonModel();
		personModel.setCpf(cpf);
		final Example<PersonModel> example = Example.of(personModel);

		return repository.findBy(example, FluentQuery.FetchableFluentQuery::first);
	}

	public boolean exists(final String cpf) {
		final PersonModel personModel = new PersonModel();
		personModel.setCpf(cpf);
		final Example<PersonModel> example = Example.of(personModel);

		return repository.exists(example);
	}
}
