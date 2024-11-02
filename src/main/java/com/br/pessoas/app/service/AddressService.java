package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.AddressResponse;
import com.br.pessoas.app.dto.AddressRequest;
import com.br.pessoas.app.mapper.impl.AdressRequestMapper;
import com.br.pessoas.app.mapper.impl.AdressResponseMapper;
import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.dataProvider.client.AddressClient;
import com.br.pessoas.infra.dataProvider.facade.GetAddressFacade;
import com.br.pessoas.infra.dataProvider.repository.impl.AdressRepositoryImpl;
import com.br.pessoas.useCase.CreateAddressUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AdressRequestMapper requestMapper;

    @Autowired
    private AdressResponseMapper responseMapper;

    @Autowired
    private AdressRepositoryImpl repository;

    @Autowired
    private AddressClient client;

    @Autowired
    private GetAddressFacade getAddressFacade;

    public AddressResponse createAddress(AddressRequest request){
        final CreateAddressUseCase create = new CreateAddressUseCase();
        return responseMapper.mapperToSource(create.createAdress(requestMapper.mapperToTarget(request), repository));
    }

    public List<AddressResponse> createAddress(List<AddressRequest> requestList) {
        return requestList.stream().map(this::createAddress).toList();
    }

    public List<AddressEntity> getAllPersonAddress(Long personId) {
        getAddressFacade.setFacadeRules(repository, client, personId);
        return getAddressFacade.execute();
    }

}
