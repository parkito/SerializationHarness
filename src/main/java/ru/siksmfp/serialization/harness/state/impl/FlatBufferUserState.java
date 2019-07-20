package ru.siksmfp.serialization.harness.state.impl;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.serializetion.impl.FlatBufferSerializer;
import ru.siksmfp.serialization.harness.state.api.OutputState;

@State(Scope.Benchmark)
public class FlatBufferUserState extends OutputState {

    public FlatBufferUserState() {
        super(new FlatBufferSerializer());
    }
}
