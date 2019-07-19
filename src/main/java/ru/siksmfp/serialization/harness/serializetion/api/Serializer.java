package ru.siksmfp.serialization.harness.serializetion.api;

public interface Serializer<T> {

    byte[] serialize(T dto);

    T deSerialize(byte [] bytes);

}
