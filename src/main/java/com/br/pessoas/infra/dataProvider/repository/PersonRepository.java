package com.br.pessoas.infra.dataProvider.repository;


import com.br.pessoas.infra.dataProvider.repository.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface representa um repositório para gerenciar entidades {@link PersonModel}.
 * Ela estende a interface {@link JpaRepository} do Spring Data JPA, fornecendo operações básicas de CRUD
 * e métodos de consulta adicionais.
 *
 * @author SeuNome
 * @since 1.0.0
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {
    // Não são necessários métodos adicionais para esta interface.
    // O Spring Data JPA gerará automaticamente implementações para os métodos definidos.
}
