package ru.siksmfp.serialization.harness.state.impl;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.state.api.InputState;
import ru.siksmfp.serialization.harness.state.api.OutputState;

@State(Scope.Benchmark)
public class StandardUserState extends OutputState implements InputState<User> {

    private User user;
    private byte[] serializedUser;

    protected StandardUserState() {
        super(null);
    }

    @Override
    public User getInputObject() {
        return user;
    }

    @Override
    public byte[] getOutputObject() {
        return serializedUser;
    }

    @Override
    public void setUp() {

    }
}