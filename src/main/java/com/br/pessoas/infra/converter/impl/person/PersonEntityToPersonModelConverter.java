package com.br.pessoas.infra.converter.impl.person;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.converter.Converter;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonEntityToPersonModelConverter implements Converter<PersonModel, PersonEntity> {
    @Override
    public PersonModel convert(PersonEntity source) {
        return new PersonModel(
                source.getNome(), source.getSobrenome(),
                source.getCpf(),source.getIdade());
    }
}
