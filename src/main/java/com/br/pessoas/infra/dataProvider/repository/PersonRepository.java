package com.br.pessoas.infra.dataProvider.repository;

import com.br.pessoas.domain.entity.PersonEntity;
import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
