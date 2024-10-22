package com.br.pessoas.infra.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<Out, In> {
    Out convert(In source);

    default List<Out> convertList(List<In> sourceList) {
        return sourceList.parallelStream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
