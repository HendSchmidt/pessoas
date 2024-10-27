package com.br.pessoas.infra.dataProvider.repository.impl;

import com.br.pessoas.infra.dataProvider.repository.AdressRepository;
import com.br.pessoas.infra.dataProvider.repository.model.AdressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class AdressDataProviderRepository  {

    @Autowired
    AdressRepository repository;


    public AdressModel save(AdressModel source) {
        return repository.save(source);
    }


    public AdressModel get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }


    public List<AdressModel> getAll() {
        return repository.findAll();
    }

    public List<AdressModel> getAllPersonAdress(Long personId){
        return repository.getAllPersonAdress(personId);
    }
}
