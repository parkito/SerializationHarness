package ru.siksmfp.serialization.harness.serializer.api;

public interface Serializer<T> {

    byte[] serialize(T dto);

    T deSerialize(byte [] bytes);

}
