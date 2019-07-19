package ru.siksmfp.serialization.harness.model.converter.api;

public interface Converter<M, D> {

    M toModel(D dto);

    D toDto(M model);
}
