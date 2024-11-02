package com.br.pessoas.infra.dataProvider.repository.impl;

import com.br.pessoas.infra.dataProvider.repository.AdressRepository;
import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;
import com.br.pessoas.infra.dataProvider.strategy.GetAddressStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdressRepositoryImpl implements GetAddressStrategy {

    @Autowired @Lazy
    private AdressRepository repository;

    public AddressModel save(AddressModel source) {
        return repository.save(source);
    }

    public AddressModel get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public List<AddressModel> getAll() {
        return repository.findAll();
    }

    @Override
    public List<AddressModel> getAllPersonAdress(Long personId){
        return repository.getAllPersonAdress(personId);
    }
}
