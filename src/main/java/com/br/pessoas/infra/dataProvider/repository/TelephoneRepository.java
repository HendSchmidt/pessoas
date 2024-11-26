package com.br.pessoas.infra.dataProvider.repository;

import com.br.pessoas.infra.dataProvider.repository.model.TelephoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelephoneRepository extends JpaRepository<TelephoneModel, Long> {}
