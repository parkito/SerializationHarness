package ru.siksmfp.serialization.harness.state.api;

import ru.siksmfp.serialization.harness.serializer.api.Serializer;

public interface OutputState<T> {

    byte[] getOutputObject();

    T getInputObject();

    Serializer<T> getSerializer();

    void setUp();
}
