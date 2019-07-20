package ru.siksmfp.serialization.harness.state.impl;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;
import ru.siksmfp.serialization.harness.serializetion.impl.CapnprotoSerializer;
import ru.siksmfp.serialization.harness.state.api.OutputState;

@State(Scope.Benchmark)
public class CapnprotoUserState implements OutputState {

    private Serializer<User> serializer;
    private byte[] serializedUser;
    private User user;

    public byte[] getOutputObject() {
        return serializedUser;
    }

    public User getInputObject() {
        return user;
    }

    public Serializer<User> getSerializer() {
        return serializer;
    }

    @Setup(Level.Trial)
    public void setUp() {
        InputUserState userState = new InputUserState();
        userState.setUp();

        user = userState.getInputObject();
        serializer = new CapnprotoSerializer();
        serializedUser = this.serializer.serialize(userState.getInputObject());
    }
}

