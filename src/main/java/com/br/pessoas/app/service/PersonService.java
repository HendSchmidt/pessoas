package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.mapper.impl.PersonResquestMapper;
import com.br.pessoas.domain.useCase.CreatePersonUseCase;
import com.br.pessoas.infra.dataProvider.strategy.enumerator.DataProviderStrategyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private AdressService adressService;

    @Autowired
    private PersonResquestMapper mapper;


    public PersonResponse createPerson(PersonResponse dto){
       final CreatePersonUseCase create = new CreatePersonUseCase(DataProviderStrategyEnum.REPOSITORY);
       // create.createPerson(mapper.mapperToOut(dto));
        return new PersonResponse();
    }

    public List<PersonResponse> getAllPerson(){
        return Collections.emptyList();
    }

}
