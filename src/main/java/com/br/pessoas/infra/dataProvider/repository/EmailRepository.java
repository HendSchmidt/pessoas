package com.br.pessoas.infra.dataProvider.repository;

import com.br.pessoas.infra.dataProvider.repository.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {}
