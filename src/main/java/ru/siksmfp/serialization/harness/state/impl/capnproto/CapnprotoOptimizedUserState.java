package ru.siksmfp.serialization.harness.state.impl.capnproto;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;
import ru.siksmfp.serialization.harness.serializer.impl.capnproto.CapnprotoOptimizedSerializer;
import ru.siksmfp.serialization.harness.state.api.OutputState;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;

@State(Scope.Benchmark)
public class CapnprotoOptimizedUserState implements OutputState<User> {

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
        serializer = new CapnprotoOptimizedSerializer();
        serializedUser = this.serializer.serialize(userState.getInputObject());
    }
}

