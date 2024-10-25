package com.br.pessoas.infra.dataProvider;

import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DataProvider {
    PersonModel savePerson(PersonModel source);
    PersonModel  getPerson(PersonModel source);
    List<PersonModel> getAllPerson ();
}
