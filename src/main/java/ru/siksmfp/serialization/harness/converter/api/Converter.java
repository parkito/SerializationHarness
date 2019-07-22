package ru.siksmfp.serialization.harness.converter.api;

public interface Converter<M, D> {

    M toModel(D dto);

    D toDto(M model);
}
