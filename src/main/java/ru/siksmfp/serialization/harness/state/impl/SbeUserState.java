package ru.siksmfp.serialization.harness.state.impl;

import ru.siksmfp.serialization.harness.serializetion.impl.SbeSerializer;
import ru.siksmfp.serialization.harness.state.api.OutputState;

public class SbeUserState extends OutputState {

    public SbeUserState() {
        super(new SbeSerializer());
    }
}
