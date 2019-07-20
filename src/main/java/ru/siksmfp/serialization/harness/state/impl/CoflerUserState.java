package ru.siksmfp.serialization.harness.state.impl;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.serializetion.impl.CoflerSerializer;
import ru.siksmfp.serialization.harness.state.api.OutputState;

@State(Scope.Benchmark)
public class CoflerUserState extends OutputState {

    public CoflerUserState() {
        super(new CoflerSerializer());
    }
}
