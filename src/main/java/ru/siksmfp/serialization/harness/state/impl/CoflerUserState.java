package ru.siksmfp.serialization.harness.state.impl;

import ru.siksmfp.serialization.harness.serializetion.impl.CoflerSerializer;
import ru.siksmfp.serialization.harness.state.api.OutputState;

public class CoflerUserState extends OutputState {

    public CoflerUserState() {
        super(new CoflerSerializer());
    }
}
