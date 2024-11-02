package com.br.pessoas.app.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper <Target, Source>{
   
    /**
 * Mapeia um objeto {@link Source} para um objeto {@link Target}.
 *
 * @param source O objeto {@link Source} a ser mapeado.
 * @return O objeto {@link Target} resultante do processo de mapeamento.
 */
    Target mapperToTarget(Source source);
    
   /**
 * Mapeia um objeto {@link Target} para um objeto {@link Source}.
 *
 * @param target O objeto {@link Target} a ser mapeado.
 * @return O objeto {@link Source} resultante do processo de mapeamento.
 */
    Source mapperToSource(Target target);

    /**
 * Este método mapeia uma lista de objetos {@link Source} para uma lista de objetos {@link Target}.
 * Ele utiliza streams paralelas para processamento eficiente de grandes conjuntos de dados.
 *
 * @param sourceList Uma lista de objetos {@link Source} a serem mapeados.
 * @return Uma lista de objetos {@link Target} resultantes do processo de mapeamento.
 *         Se a lista de entrada for nula ou vazia, uma lista vazia será retornada.
 */
    default List<Target> mapperToTarget(List<Source> sourceList) {
        return sourceList.parallelStream()
                .map(this::mapperToTarget)
                .collect(Collectors.toList());
    }

    /**
 * Este método mapeia uma lista de objetos {@link Target} para uma lista de objetos {@link Source}.
 * Ele utiliza streams paralelas para processamento eficiente de grandes conjuntos de dados.
 *
 * @param outList Uma lista de objetos {@link Target} a serem mapeados.
 * @return Uma lista de objetos {@link Source} resultantes do processo de mapeamento.
 *         Se a lista de entrada for nula ou vazia, uma lista vazia será retornada.
 */
    default List<Source> mapperToSource(List<Target> outList) {
        return outList.parallelStream()
                .map(this::mapperToSource)
                .collect(Collectors.toList());
    }
}
