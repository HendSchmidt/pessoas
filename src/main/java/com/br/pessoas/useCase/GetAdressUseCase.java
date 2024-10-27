package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.AdressEntity;
import com.br.pessoas.infra.converter.impl.adress.AdressEntityToAdressModelConverter;
import com.br.pessoas.infra.converter.impl.adress.AdressModelToAdressEntityConverter;
import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.dataProvider.repository.model.AdressModel;

import java.util.List;
import java.util.stream.Collectors;

public class GetAdressUseCase {

    private AdressEntityToAdressModelConverter toModel;
    private AdressModelToAdressEntityConverter toEntity;

    public GetAdressUseCase() {
        this.toModel = new AdressEntityToAdressModelConverter();
        this.toEntity = new AdressModelToAdressEntityConverter();
    }

    public AdressEntity getAdress (Long personId, DataProvider dataProvider) {
        return toEntity.convert((AdressModel) dataProvider.get(personId));
    }
}
