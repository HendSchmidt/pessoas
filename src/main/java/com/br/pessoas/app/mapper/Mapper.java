package com.br.pessoas.app.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


public interface Mapper <Out, In>{
    Out mapperToOut(In dto);
    In mapperToIn(Out entity);

    default List<Out> mapperToOut(List<In> inList) {
        return inList.parallelStream()
                .map(this::mapperToOut)
                .collect(Collectors.toList());
    }

    default List<In> mapperToIn(List<Out> outList) {
        return outList.parallelStream()
                .map(this::mapperToIn)
                .collect(Collectors.toList());
    }
}
