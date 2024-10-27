package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.AdressRequest;
import com.br.pessoas.app.dto.PersonRequest;
import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.mapper.impl.PersonResponseMapper;
import com.br.pessoas.app.mapper.impl.PersonResquestMapper;
import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.useCase.CreatePersonUseCase;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonDataProviderRepository;
import com.br.pessoas.useCase.GetAllPersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private AdressService adressService;

    @Autowired
    private PersonResquestMapper requestMapper;

    @Autowired
    private PersonResponseMapper responseMapper;

    @Autowired
    private PersonDataProviderRepository repository;

    public PersonResponse createPerson(PersonRequest request){
        final CreatePersonUseCase create = new CreatePersonUseCase();
        PersonResponse personResponse = responseMapper.mapperToSource(create.createPerson(requestMapper.mapperToTarget(request), repository));
        request.getAdressRequestList().forEach(request1 -> request1.setPersonId(personResponse.getId()));
        personResponse.setAdressResponseList(adressService.createAdress(request.getAdressRequestList().stream().toList()));

        return personResponse;
    }

    public List<PersonResponse> getAllPerson(){
        final GetAllPersonUseCase getAllPerson = new GetAllPersonUseCase();
       return getAllPerson.getAllPerson(repository)
               .stream().peek(person -> person.setAdressEntityList(adressService.getAllPersonAdress(person.getId())))
               .map(responseMapper::mapperToSource)
               .toList();
    }

}
