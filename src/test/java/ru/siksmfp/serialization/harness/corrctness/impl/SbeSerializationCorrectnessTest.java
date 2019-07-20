package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.serializetion.impl.SbeSerializer;
import ru.siksmfp.serialization.harness.state.impl.SbeUserState;

public class SbeSerializationCorrectnessTest extends ParentSerializationTest {

    SbeSerializationCorrectnessTest() {
        super(new SbeSerializer(), new SbeUserState());
    }
}
