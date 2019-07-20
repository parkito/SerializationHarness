package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.serializer.impl.CapnprotoSerializer;
import ru.siksmfp.serialization.harness.state.impl.CapnprotoUserState;

public class CapnprotoSerializationCorrectnessTest extends ParentSerializationTest {

    CapnprotoSerializationCorrectnessTest() {
        super(new CapnprotoSerializer(), new CapnprotoUserState());
    }
}
