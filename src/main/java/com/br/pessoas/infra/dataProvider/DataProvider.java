package com.br.pessoas.infra.dataProvider;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.model.request.PersonDataProviderRequest;
import com.br.pessoas.infra.model.response.PersonDataProviderResponse;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DataProvider {
    PersonEntity savePerson(PersonEntity source);
    PersonEntity  getPerson(PersonEntity source);
    List<PersonEntity> getAllPerson ();
}
