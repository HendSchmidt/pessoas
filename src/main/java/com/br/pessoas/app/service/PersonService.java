package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.*;
import com.br.pessoas.app.mapper.impl.person.PersonResponseMapper;
import com.br.pessoas.app.mapper.impl.person.PersonResquestMapper;
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
    private TelephoneService telephoneService;

    @Autowired
    private EmailService emailService;

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
        List<PersonResponse> personResponses = responseMapper.mapperToSource(getAllPerson.getAllPerson(repositoryImpl));

        return personResponses.parallelStream().peek(this::setAllPersonComplements).toList();
    }

    private void setAllPersonComplements(PersonResponse personResponse) {
        personResponse.setEmailResponseList(getAllEmailForPerson(personResponse.getId()));
        personResponse.setTelephoneResponseList(getAllTelephoneForPerson(personResponse.getId()));
        personResponse.setAdressResponseList(getAllAddressForPerson(personResponse.getId()));
    }

    public AddressResponse createPersonAddress(final Long personId, final AddressRequest addressRequest) {
        addressRequest.setPersonId(personId);
        return addressService.createAddress(addressRequest);
    }

    public TelephoneResponse createPersonTelephone(final Long personId, final TelephoneRequest telephoneRequest){
        telephoneRequest.setPersonId(personId);
        return telephoneService.create(telephoneRequest);
    }

    public EmailResponse createPersonEmail(final Long personId, final EmailRequest emailRequest){
        emailRequest.setPersonId(personId);
        return emailService.create(emailRequest);
    }

    private List<AddressResponse> getAllAddressForPerson(final Long personId){
        return addressService.getAllPersonAddress(personId);
    }

    private List<EmailResponse> getAllEmailForPerson(final Long personId){
        return emailService.findAllByPersonId(personId);
    }

    private List<TelephoneResponse> getAllTelephoneForPerson(final Long personId){
        return telephoneService.findAllByPersonId(personId);
    }

}
