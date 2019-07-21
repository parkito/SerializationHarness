package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.serializer.impl.SbeSerializer;
import ru.siksmfp.serialization.harness.state.impl.SbeUserState;

public class SbeSerializationTest extends ParentSerializationTest {

    SbeSerializationTest() {
        super(new SbeSerializer(), new SbeUserState());
    }
}
