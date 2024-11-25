package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.*;
import com.br.pessoas.app.mapper.impl.person.PersonResponseMapper;
import com.br.pessoas.app.mapper.impl.person.PersonResquestMapper;
import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;
import com.br.pessoas.useCase.CreatePersonUseCase;
import com.br.pessoas.useCase.FindAllPersonUseCase;
import com.br.pessoas.useCase.FindPersonByCpfUseCase;
import com.br.pessoas.useCase.exception.PersonRecoveryException;
import com.br.pessoas.useCase.VerifyPersonExistsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Esta classe fornece serviços relacionados à gestão de pessoas.
 */
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
    public PersonResponse create(PersonRequest request){
        final CreatePersonUseCase create = new CreatePersonUseCase();
        final VerifyPersonExistsUseCase verifyPerson = new VerifyPersonExistsUseCase();

        if(verifyPerson.exists(request.getCpf(), repositoryImpl)) throw new PersonRecoveryException("Já existe uma pessoa cadastrada com esse CPF.");

        return responseMapper.mapperToSource(create.create(requestMapper.mapperToTarget(request), repositoryImpl));
    }

    public PersonResponse findByCpf(final String cpf){
        final FindPersonByCpfUseCase findPersonByCpfUseCase = new FindPersonByCpfUseCase();

        PersonResponse personResponse = responseMapper.mapperToSource(findPersonByCpfUseCase.findByCpf(cpf, repositoryImpl));
        setAllComplements(personResponse);

        return personResponse;
    }

    public List<PersonResponse> findAllPerson(){
        final FindAllPersonUseCase useCase = new FindAllPersonUseCase();
        List<PersonResponse> personResponses = responseMapper.mapperToSource(useCase.findAllPerson(repositoryImpl));

        return personResponses.parallelStream().peek(this::setAllComplements).toList();
    }

    private void setAllComplements(PersonResponse personResponse) {
        personResponse.setEmailResponseList(findAllEmail(personResponse.getId()));
        personResponse.setTelephoneResponseList(findAllTelephone(personResponse.getId()));
        personResponse.setAdressResponseList(findAllAddress(personResponse.getId()));
    }

    public AddressResponse createAddress(final Long personId, final AddressRequest addressRequest) {
        return addressService.create(addressRequest, personId);
    }

    public TelephoneResponse createTelephone(final Long personId, final TelephoneRequest telephoneRequest){
        return telephoneService.create(telephoneRequest, personId);
    }

    public EmailResponse createEmail(final Long personId, final EmailRequest emailRequest){
        return emailService.create(emailRequest, personId);
    }

    private List<AddressResponse> findAllAddress(final Long personId){
        return addressService.findAll(personId);
    }

    private List<EmailResponse> findAllEmail(final Long personId){
        return emailService.findAll(personId);
    }

    private List<TelephoneResponse> findAllTelephone(final Long personId){
        return telephoneService.findAll(personId);
    }

}
