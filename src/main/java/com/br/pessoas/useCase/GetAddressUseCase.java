package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.converter.impl.adress.AddressModelToAddressEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.AdressRepositoryImpl;
import com.br.pessoas.infra.dataProvider.strategy.GetAddressContext;
import com.br.pessoas.infra.dataProvider.strategy.GetAddressStrategy;

import java.util.List;

public class GetAddressUseCase {
    private final AddressModelToAddressEntityConverter toEntity;

    public GetAddressUseCase() {
        this.toEntity = new AddressModelToAddressEntityConverter();
    }

    public AddressEntity getAdress (Long id, AdressRepositoryImpl repository) {
        return toEntity.convert(repository.get(id));
    }

    public List<AddressEntity> getAllPersonAddress(Long personId, GetAddressStrategy strategy){
        GetAddressContext addressContext = new GetAddressContext(strategy);
        return toEntity.convertList(addressContext.getAllPersonAdress(personId));
    }
}
