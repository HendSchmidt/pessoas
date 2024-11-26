package com.br.pessoas.infra.converter.impl.person;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityToModelConverter implements Converter<PersonModel, PersonEntity> {
    @Override
    public PersonModel convert(PersonEntity entity) {
        return new PersonModel(
                entity.getNome(), entity.getSobrenome(),
                entity.getCpf(),entity.getIdade());
    }
}
