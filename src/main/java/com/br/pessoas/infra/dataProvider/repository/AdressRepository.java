package com.br.pessoas.infra.dataProvider.repository;

import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Esta interface representa um repositório para gerenciar entidades {@link AddressModel}.
 * Ela estende o Spring Data JPA's {@link JpaRepository} para fornecer operações básicas de CRUD.
 * Além disso, inclui um método de consulta personalizado para recuperar todos os endereços associados a uma pessoa específica.
 */
@Repository
public interface AdressRepository extends JpaRepository<AddressModel, Long> {}
