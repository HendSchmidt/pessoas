package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.PersonRequest;
import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.mapper.impl.PersonResponseMapper;
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
    private PersonResquestMapper requestMapper;

    @Autowired
    private PersonResponseMapper responseMapper;


    public PersonResponse createPerson(PersonRequest request){
       final CreatePersonUseCase create = new CreatePersonUseCase(DataProviderStrategyEnum.REPOSITORY);
        return responseMapper.mapperToSource(create.createPerson(requestMapper.mapperToTarget(request)));
    }

    public List<PersonResponse> getAllPerson(){
        return Collections.emptyList();
    }

}
