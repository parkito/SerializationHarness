package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.serializer.impl.capnproto.CapnprotoPackedSerializer;
import ru.siksmfp.serialization.harness.state.impl.capnproto.CapnprotoPackedUserState;

public class CapnprotoPackedSerializationTest extends ParentSerializationTest {

    CapnprotoPackedSerializationTest() {
        super(new CapnprotoPackedSerializer(), new CapnprotoPackedUserState());
    }
}
