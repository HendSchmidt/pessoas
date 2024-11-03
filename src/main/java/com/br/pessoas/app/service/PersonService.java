package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.AddressRequest;
import com.br.pessoas.app.dto.AddressResponse;
import com.br.pessoas.app.dto.PersonRequest;
import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.mapper.impl.PersonResponseMapper;
import com.br.pessoas.app.mapper.impl.PersonResquestMapper;
import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;
import com.br.pessoas.useCase.CreatePersonUseCase;
import com.br.pessoas.useCase.GetAllPersonUseCase;
import com.br.pessoas.useCase.GetPersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private PersonResquestMapper requestMapper;

    @Autowired
    private PersonResponseMapper responseMapper;

    @Autowired
    private PersonRepositoryImpl repositoryImpl;

    @Transactional
    public PersonResponse createPerson(PersonRequest request){
        final CreatePersonUseCase create = new CreatePersonUseCase();
        return responseMapper.mapperToSource(create.createPerson(requestMapper.mapperToTarget(request), repositoryImpl));
    }

    public List<PersonResponse> getAllPerson(){
        final GetAllPersonUseCase getAllPerson = new GetAllPersonUseCase();
        return responseMapper.mapperToSource(getAllPerson.getAllPerson(repositoryImpl))
                .stream().parallel().peek(response -> response.setAdressResponseList(getAllAddressForPerson(response.getId()))).toList();
    }

    public PersonResponse createPersonAddress(final Long personId, final AddressRequest addressRequest) {
        final GetPersonUseCase useCase = new  GetPersonUseCase();
        useCase.getPerson(personId, repositoryImpl);
        addressService.createAddress(personId, addressRequest);
        return null;
    }

    private List<AddressResponse> getAllAddressForPerson(final Long personId){
        return addressService.getAllPersonAddress(personId);
    }
}
