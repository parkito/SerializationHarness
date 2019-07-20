package ru.siksmfp.serialization.harness.state.impl;

import ru.siksmfp.serialization.harness.serializetion.impl.CapnprotoSerializer;
import ru.siksmfp.serialization.harness.state.api.OutputState;

public class CapnprotoUserState extends OutputState {

    public CapnprotoUserState() {
        super(new CapnprotoSerializer());
    }
}

