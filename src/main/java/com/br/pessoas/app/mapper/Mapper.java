package com.br.pessoas.app.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper <Target, Source>{
    Target mapperToTarget(Source source);
    Source mapperToSource(Target target
    );

    default List<Target> mapperToTarget(List<Source> sourceList) {
        return sourceList.parallelStream()
                .map(this::mapperToTarget)
                .collect(Collectors.toList());
    }

    default List<Source> mapperToSource(List<Target> outList) {
        return outList.parallelStream()
                .map(this::mapperToSource)
                .collect(Collectors.toList());
    }
}
