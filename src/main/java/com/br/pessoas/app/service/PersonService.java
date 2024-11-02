package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.AddressResponse;
import com.br.pessoas.app.dto.AddressRequest;
import com.br.pessoas.app.dto.PersonRequest;
import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.mapper.impl.PersonResponseMapper;
import com.br.pessoas.app.mapper.impl.PersonResquestMapper;
import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;
import com.br.pessoas.useCase.CreatePersonUseCase;
import com.br.pessoas.useCase.GetAllPersonUseCase;
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
        PersonResponse personResponse = responseMapper.mapperToSource(create.createPerson(requestMapper.mapperToTarget(request), repositoryImpl));
        personResponse.setAdressResponseList(createAddressForPerson(personResponse.getId(),  request.getAdressRequestList().stream().toList()));
        return personResponse;
    }

    public List<PersonResponse> getAllPerson(){
        final GetAllPersonUseCase getAllPerson = new GetAllPersonUseCase();
       return getAllPerson.getAllPerson(repositoryImpl)
               .stream().peek(person -> person.setAdressEntityList(getAllAddressForPerson(person.getId())))
               .map(responseMapper::mapperToSource)
               .toList();
    }

    private List<AddressResponse> createAddressForPerson(final Long personId, List<AddressRequest> adressRequestList) {
        return addressService.createAddress(adressRequestList.stream().peek(request -> request.setPersonId(personId)).toList());
    }

    private List<AddressEntity> getAllAddressForPerson(final Long personId){
        return addressService.getAllPersonAddress(personId);
    }
}
