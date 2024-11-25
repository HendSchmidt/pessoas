package com.br.pessoas.useCase;

import com.br.pessoas.infra.dataProvider.repository.impl.PersonRepositoryImpl;
/**
 * Esta classe é responsável por verificar se uma pessoa com um determinado CPF existe no sistema.
 */
public class VerifyPersonExistsUseCase {
    public boolean exists(String cpf, PersonRepositoryImpl dataProvider){
        return dataProvider.exists(cpf);
    }
}
