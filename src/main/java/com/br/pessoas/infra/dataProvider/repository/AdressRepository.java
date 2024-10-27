package com.br.pessoas.infra.dataProvider.repository;

import com.br.pessoas.infra.dataProvider.repository.model.AdressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<AdressModel, Long> {

    @Query("SELECT a FROM AdressModel a WHERE a.personId = :personId")
    List<AdressModel> getAllPersonAdress(@Param("personId") Long personId);
}
