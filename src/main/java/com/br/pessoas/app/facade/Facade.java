package com.br.pessoas.app.facade;

import java.util.List;
/**
 * Define uma interface comum para operações de acesso a dados, utilizando o padrão de design Facade.
 * O padrão Facade fornece uma interface simplificada para um subsistema complexo,
 * ocultando a complexidade e proporcionando uma interface mais amigável para os clientes.
 *
 * @param <T> O tipo de objetos a ser manipulado pelo Facade.
 */
public interface Facade <T> {
	/**
 * Executa uma operação de recuperação de dados e retorna uma lista de objetos do tipo T.
 *
 * @return Uma lista de objetos do tipo T. A lista pode estar vazia se nenhum dado for encontrado.
 * @throws Exception Se ocorrer um erro durante a operação de recuperação de dados.
 *
 * @see List
 */
	T execute();
}
