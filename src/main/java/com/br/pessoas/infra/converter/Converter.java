package com.br.pessoas.infra.converter;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public interface Converter<Target, Source> {
    /**
 * Converte um único objeto de origem para um objeto de destino.
 *
 * @param source O objeto de origem a ser convertido. Este objeto não deve ser nulo.
 * @return O objeto de destino convertido.
 */
    Target convert(Source source);

    /**
 * Converte uma lista de objetos de origem para uma lista de objetos de destino.
 * Utiliza a interface {@link Converter} para realizar a conversão individual de cada objeto.
 * A conversão é realizada em paralelo para melhorar o desempenho, caso a lista de origem seja grande.
 *
 * @param sourceList A lista de objetos de origem a serem convertidos. Esta lista não deve ser nula.
 * @return Uma lista de objetos de destino convertidos.
 */
    default List<Target> convert(List<Source> sourceList) {
        return sourceList.parallelStream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
