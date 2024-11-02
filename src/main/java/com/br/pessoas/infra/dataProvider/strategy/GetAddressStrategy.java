package com.br.pessoas.infra.dataProvider.strategy;

import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;

import java.util.List;

/**
 * Esta interface define uma estratégia para recuperar dados de endereço relacionados a uma pessoa.
 * Ela implementa o padrão de design Strategy, que permite a separação de responsabilidades e a flexibilidade
 * na escolha de algoritmos específicos para diferentes operações.
 */
public interface GetAddressStrategy {

/**
 * Recupera todos os endereços associados a uma pessoa identificada pelo ID fornecido.
 *
 * @param id O identificador exclusivo da pessoa.
 * @return Uma lista de objetos {@link AddressModel} que representam os endereços da pessoa.
 *         Se nenhum endereço for encontrado, uma lista vazia será retornada.
 */
    List<AddressModel> getAllPersonAdress(Long id);
}
