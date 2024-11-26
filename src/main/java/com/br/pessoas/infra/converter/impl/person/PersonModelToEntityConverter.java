package com.br.pessoas.infra.converter.impl.person;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.stereotype.Component;

@Component
public class PersonModelToEntityConverter implements Converter<PersonEntity, PersonModel> {
    @Override
    public PersonEntity convert(PersonModel model) {
        return  new PersonEntity(model.getId(),
                model.getNome(), model.getSobrenome(),
                model.getCpf(),model.getIdade());
    }
}
