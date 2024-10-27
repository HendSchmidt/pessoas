package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.AdressEntity;
import com.br.pessoas.infra.converter.impl.adress.AdressEntityToAdressModelConverter;
import com.br.pessoas.infra.converter.impl.adress.AdressModelToAdressEntityConverter;
import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.dataProvider.repository.model.AdressModel;

public class CreateAdressUseCase {

    private AdressEntityToAdressModelConverter toModel;
    private AdressModelToAdressEntityConverter toEntity;

    public CreateAdressUseCase() {
        this.toModel = new AdressEntityToAdressModelConverter();
        this.toEntity = new AdressModelToAdressEntityConverter();
    }

    public AdressEntity createAdress(AdressEntity entity, DataProvider dataProvider){
        return toEntity.convert((AdressModel) dataProvider.save(toModel.convert(entity)));
    }

}
