package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.serializer.impl.capnproto.CapnprotoOptimizedSerializer;
import ru.siksmfp.serialization.harness.state.impl.CapnprotoOptimizedUserState;

public class CapnprotoOptimizedSerializationTest extends ParentSerializationTest {

    CapnprotoOptimizedSerializationTest() {
        super(new CapnprotoOptimizedSerializer(), new CapnprotoOptimizedUserState());
    }
}
