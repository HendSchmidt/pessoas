package com.br.pessoas.infra.dataProvider.strategy;

import com.br.pessoas.infra.dataProvider.repository.model.AddressModel;

import java.util.List;

/**
 * Esta classe atua como um contexto para executar diferentes estratégias para recuperar dados de endereço.
 * Ela encapsula o objeto de estratégia e delega a recuperação de dados reais para a estratégia.
 * Ela implementa o padrão de design Strategy, que permite a separação de responsabilidades e a flexibilidade
 * na escolha de algoritmos específicos para diferentes operações.
 */
public class GetAddressContext {

/**
 * O objeto de estratégia que define a forma específica de recuperar dados de endereço.
 */
    private final GetAddressStrategy strategy;

/**
 * Construtor que inicializa o objeto de estratégia.
 *
 * @param strategy O objeto de estratégia a ser usado para recuperar dados de endereço.
 */
    public GetAddressContext(final GetAddressStrategy strategy) {
        this.strategy = strategy;
    }

/**
 * Recupera todos os endereços associados a uma pessoa usando o objeto de estratégia.
 *
 * @param id O identificador exclusivo da pessoa.
 * @return Uma lista de objetos {@link AddressModel} que representam os endereços da pessoa.
 */
    public List<AddressModel> getAllPersonAdress(Long id) {
        return strategy.getAllPersonAdress(id);
    }
}
