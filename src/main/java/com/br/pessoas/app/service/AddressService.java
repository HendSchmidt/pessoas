package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.AddressRequest;
import com.br.pessoas.app.dto.AddressResponse;
import com.br.pessoas.app.mapper.impl.address.AddressResponseMapper;
import com.br.pessoas.app.service.facade.CreateAddressFacade;
import com.br.pessoas.infra.dataProvider.client.AddressClient;
import com.br.pessoas.infra.dataProvider.repository.impl.AddressRepositoryImpl;
import com.br.pessoas.useCase.GetAddressUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressResponseMapper responseMapper;

    @Autowired
    private AddressRepositoryImpl repository;

    @Autowired
    private AddressClient client;

    @Autowired
    private CreateAddressFacade getAddressFacade;

    @Transactional
    public AddressResponse createAddress(final AddressRequest request, final Long personId){
        CreateAddressFacade createAddressFacade = new CreateAddressFacade();
        createAddressFacade.setFacadeRules(repository, client, request, personId);
        return responseMapper.mapperToSource(createAddressFacade.execute());
    }

    public List<AddressResponse> getAllPersonAddress(Long personId) {
        final GetAddressUseCase useCase = new GetAddressUseCase();
        return responseMapper.mapperToSource(useCase.getAllPersonAddress(personId, repository));
    }

}
