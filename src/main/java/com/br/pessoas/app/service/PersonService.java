package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.AdressRequest;
import com.br.pessoas.app.dto.PersonRequest;
import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.mapper.impl.PersonResponseMapper;
import com.br.pessoas.app.mapper.impl.PersonResquestMapper;
import com.br.pessoas.useCase.CreatePersonUseCase;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonDataProviderRepository;
import com.br.pessoas.useCase.GetAllPersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        personResponse.setAdressResponseList(adressService.createAdress(request.getAdressRequestList().stream().toList()));

        return personResponse;
    }

    public List<PersonResponse> getAllPerson(){
        final GetAllPersonUseCase getAllPerson = new GetAllPersonUseCase();
        return responseMapper.mapperToSource(getAllPerson.getAllPerson(repository));
    }

}
