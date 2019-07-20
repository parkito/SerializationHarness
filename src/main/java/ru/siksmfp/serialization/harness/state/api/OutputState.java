package ru.siksmfp.serialization.harness.state.api;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;

public class OutputState {

    private Serializer<User> serializer;
    private byte[] serializedUser;

    protected OutputState(Serializer<User> serializer) {
        this.serializer = serializer;
    }

    public byte[] getOutputObject() {
        return serializedUser;
    }

    public Serializer<User> getSerializer() {
        return serializer;
    }

    @Setup(Level.Trial)
    public void setUp() {
        InputUserState userState = new InputUserState();
        serializedUser = serializer.serialize(userState.getInputObject());
    }
}
