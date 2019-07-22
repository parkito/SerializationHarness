package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.serializer.impl.capnproto.CapnprotoSerializer;
import ru.siksmfp.serialization.harness.state.impl.capnproto.CapnprotoUserState;

public class CapnprotoSerializationTest extends ParentSerializationTest {

    CapnprotoSerializationTest() {
        super(new CapnprotoSerializer(), new CapnprotoUserState());
    }
}
