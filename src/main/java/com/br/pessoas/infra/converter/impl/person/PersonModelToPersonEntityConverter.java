package com.br.pessoas.infra.converter.impl.person;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonModelToPersonEntityConverter implements Converter<PersonEntity, PersonModel> {
    @Override
    public PersonEntity convert(PersonModel source) {
        return  new PersonEntity(source.getId(),
                source.getNome(), source.getSobrenome(),
                source.getCpf(),source.getIdade(),
                List.of());
    }
}
