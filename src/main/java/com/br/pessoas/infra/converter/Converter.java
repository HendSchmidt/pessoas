package com.br.pessoas.infra.converter;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public interface Converter<Target, Source> {
    Target convert(Source source);

    default List<Target> convertList(List<Source> sourceList) {
        return sourceList.parallelStream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
