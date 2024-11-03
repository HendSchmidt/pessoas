package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.converter.impl.adress.AddressModelToAddressEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.AddressRepositoryImpl;

import java.util.List;

public class GetAddressUseCase {
    private final AddressModelToAddressEntityConverter toEntity;

    public GetAddressUseCase() {
        this.toEntity = new AddressModelToAddressEntityConverter();
    }

    public List<AddressEntity> getAllPersonAddress(Long personId, AddressRepositoryImpl repository){
        return toEntity.convertList(repository.getAllPersonAdress(personId));
    }
}
