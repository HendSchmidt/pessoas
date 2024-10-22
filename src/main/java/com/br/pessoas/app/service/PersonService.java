package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.mapper.Mapper;
import com.br.pessoas.domain.entity.PersonEntity;
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
    private Mapper<PersonEntity, PersonResponse> mapper;


    public PersonResponse createPersonDto(PersonResponse dto){
        CreatePersonUseCase create = new CreatePersonUseCase(DataProviderStrategyEnum.REPOSITORY);
        create.createPerson(mapper.mapperToOut(dto));
        return new PersonResponse();
    }

    public List<PersonResponse> getAllPerson(){
        return Collections.emptyList();
    }

}