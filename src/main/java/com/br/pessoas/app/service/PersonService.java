package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.*;
import com.br.pessoas.app.mapper.impl.person.PersonResponseMapper;
import com.br.pessoas.app.mapper.impl.person.PersonResquestMapper;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;
import com.br.pessoas.useCase.CreatePersonUseCase;
import com.br.pessoas.useCase.GetAllPersonUseCase;
import com.br.pessoas.useCase.exception.GetPersonByCpfUseCase;
import com.br.pessoas.useCase.exception.PersonRecoveryException;
import com.br.pessoas.useCase.exception.VerifyPersonExistsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.TRUE;

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
        final VerifyPersonExistsUseCase verifyPersonExistsUseCase = new VerifyPersonExistsUseCase();

        if(verifyPersonExistsUseCase.exists(request.getCpf(), repositoryImpl)) throw new PersonRecoveryException("Já existe uma pessoa cadastrada com esse CPF.");

        return responseMapper.mapperToSource(create.createPerson(requestMapper.mapperToTarget(request), repositoryImpl));
    }

    public PersonResponse findByCpf(final String cpf){
        final GetPersonByCpfUseCase getPersonByCpfUseCase = new GetPersonByCpfUseCase();

        PersonResponse personResponse = responseMapper.mapperToSource(getPersonByCpfUseCase.findByCpf(cpf, repositoryImpl));
        setAllPersonComplements(personResponse);

        return personResponse;
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
        return addressService.createAddress(addressRequest, personId);
    }

    public TelephoneResponse createPersonTelephone(final Long personId, final TelephoneRequest telephoneRequest){
        return telephoneService.create(telephoneRequest, personId);
    }

    public EmailResponse createPersonEmail(final Long personId, final EmailRequest emailRequest){
        return emailService.create(emailRequest, personId);
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
