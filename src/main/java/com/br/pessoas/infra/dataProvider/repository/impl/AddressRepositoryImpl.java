package com.br.pessoas.infra.dataProvider.repository.impl;

import com.br.pessoas.infra.dataProvider.repository.AdressRepository;
import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressRepositoryImpl {

    @Autowired @Lazy
    private AdressRepository repository;

    public AddressModel save(AddressModel source) {
        return repository.save(source);
    }

    public List<AddressModel> findAllByPersonId(Long personId){
        AddressModel model = new AddressModel();
        model.setPersonId(personId);
        Example<AddressModel> example = Example.of(model);

        return repository.findAll(example, Sort.by(Sort.Order.asc("cidade")));
    }
}
