package ru.siksmfp.serialization.harness.state.api;

import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;

public interface OutputState {

    byte[] getOutputObject();

    User getInputObject();

    Serializer<User> getSerializer();

    void setUp();
}
