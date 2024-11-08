package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.AddressEntity;
import com.br.pessoas.infra.converter.impl.adress.AddressEntityToAddressModelConverter;
import com.br.pessoas.infra.converter.impl.adress.AddressModelToAddressEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.impl.AddressRepositoryImpl;

public class CreateAddressUseCase {

    private final AddressEntityToAddressModelConverter toModel;
    private final AddressModelToAddressEntityConverter toEntity;

    public CreateAddressUseCase() {
        this.toModel = new AddressEntityToAddressModelConverter();
        this.toEntity = new AddressModelToAddressEntityConverter();
    }

    public AddressEntity createAdress(AddressEntity entity, AddressRepositoryImpl repository){
        return toEntity.convert(repository.save(toModel.convert(entity)));
    }

}
