package com.br.pessoas.infra.dataProvider.strategy;

import com.br.pessoas.infra.dataProvider.DataProvider;
import com.br.pessoas.infra.dataProvider.client.PersonDataProviderClient;
import com.br.pessoas.infra.dataProvider.repository.PersonDataProviderRepository;
import com.br.pessoas.infra.dataProvider.strategy.enumerator.DataProviderStrategyEnum;

import java.util.HashMap;
import java.util.Map;

public class DataProviderStrategy {
   private final Map<DataProviderStrategyEnum, DataProvider> strategies;

    public DataProviderStrategy() {
        this.strategies = new HashMap<>();
        this.strategies.put(DataProviderStrategyEnum.CLIENT, new PersonDataProviderClient());
        this.strategies.put(DataProviderStrategyEnum.REPOSITORY, new PersonDataProviderRepository());
    }

    public DataProvider getStrategies(DataProviderStrategyEnum key) {
        return strategies.get(key);
    }
}
