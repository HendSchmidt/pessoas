package com.br.pessoas.useCase;

import com.br.pessoas.domain.entity.AdressEntity;
import com.br.pessoas.infra.converter.impl.adress.AdressEntityToAdressModelConverter;
import com.br.pessoas.infra.converter.impl.adress.AdressModelToAdressEntityConverter;
import com.br.pessoas.infra.dataProvider.repository.AdressRepository;
import com.br.pessoas.infra.dataProvider.repository.impl.AdressDataProviderRepository;

import java.util.List;

public class GetAdressUseCase {

    private AdressEntityToAdressModelConverter toModel;
    private AdressModelToAdressEntityConverter toEntity;

    public GetAdressUseCase() {
        this.toModel = new AdressEntityToAdressModelConverter();
        this.toEntity = new AdressModelToAdressEntityConverter();
    }

    public AdressEntity getAdress (Long id, AdressDataProviderRepository repository) {
        return toEntity.convert( repository.get(id));
    }

    public List<AdressEntity> getAllPersonAdress(Long personId,AdressDataProviderRepository repository){
        return toEntity.convertList(repository.getAllPersonAdress(personId));
    }
}
