package ru.siksmfp.serialization.harness.state.impl;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.serializetion.impl.SbeSerializer;
import ru.siksmfp.serialization.harness.state.api.OutputState;

@State(Scope.Benchmark)
public class SbeUserState extends OutputState {

    public SbeUserState() {
        super(new SbeSerializer());
    }
}
