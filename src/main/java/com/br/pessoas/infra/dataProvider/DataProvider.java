package com.br.pessoas.infra.dataProvider;

import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DataProvider<Source> {
    Source save(Source source);
    Source get(Long id);
    List<Source> getAll();
}
