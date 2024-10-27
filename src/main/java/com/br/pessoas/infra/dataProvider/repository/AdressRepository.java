package com.br.pessoas.infra.dataProvider.repository;

import com.br.pessoas.infra.dataProvider.repository.model.AdressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<AdressModel, Long> {
}
