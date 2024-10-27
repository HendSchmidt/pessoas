package com.br.pessoas.app.service;

import com.br.pessoas.app.dto.AdressRequest;
import com.br.pessoas.app.dto.AdressResponse;
import com.br.pessoas.app.mapper.impl.AdressRequestMapper;
import com.br.pessoas.app.mapper.impl.AdressResponseMapper;
import com.br.pessoas.infra.dataProvider.repository.impl.AdressDataProviderRepository;
import com.br.pessoas.useCase.CreateAdressUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressService {

    @Autowired
    private AdressRequestMapper requestMapper;

    @Autowired
    private AdressResponseMapper responseMapper;

    @Autowired
    private AdressDataProviderRepository repository;

    public AdressResponse createAdress (AdressRequest request){
        final CreateAdressUseCase create = new CreateAdressUseCase();
        return responseMapper.mapperToSource(create.createAdress(requestMapper.mapperToTarget(request), repository));
    }

    public List<AdressResponse> createAdress (List<AdressRequest> requestList){
        return requestList.stream().map(this::createAdress).toList();
    }

    public List<AdressResponse> getAddressForPerson(Long personId){
        return null;
    }
}
