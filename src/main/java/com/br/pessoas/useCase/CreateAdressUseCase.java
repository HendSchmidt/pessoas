package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.AdressEntity;
import com.br.pessoas.infra.converter.impl.adress.AdressEntityToAdressModelConverter;
import com.br.pessoas.infra.converter.impl.adress.AdressModelToAdressEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.AdressRepository;
import com.br.pessoas.infra.dataProvider.repository.impl.AdressDataProviderRepository;
import com.br.pessoas.infra.dataProvider.repository.model.AdressModel;

public class CreateAdressUseCase {

    private AdressEntityToAdressModelConverter toModel;
    private AdressModelToAdressEntityConverter toEntity;

    public CreateAdressUseCase() {
        this.toModel = new AdressEntityToAdressModelConverter();
        this.toEntity = new AdressModelToAdressEntityConverter();
    }

    public AdressEntity createAdress(AdressEntity entity, AdressDataProviderRepository repository){
        return toEntity.convert(repository.save(toModel.convert(entity)));
    }

}
