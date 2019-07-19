package ru.siksmfp.serialization.harness.converter.api;

public interface Serializer<T> {

    byte[] serialize(T dto);

    T deSerialize(byte [] bytes);

}
