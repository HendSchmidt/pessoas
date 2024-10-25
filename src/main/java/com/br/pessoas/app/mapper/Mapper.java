package com.br.pessoas.app.mapper;

import java.util.List;
import java.util.stream.Collectors;


public interface Mapper <Target, Source>{
    Target mapperToOut(Source source);
    Source mapperToIn(Target target
    );

    default List<Target> mapperToOut(List<Source> sourceList) {
        return sourceList.parallelStream()
                .map(this::mapperToOut)
                .collect(Collectors.toList());
    }

    default List<Source> mapperToIn(List<Target> outList) {
        return outList.parallelStream()
                .map(this::mapperToIn)
                .collect(Collectors.toList());
    }
}
