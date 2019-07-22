package ru.siksmfp.serialization.harness.corrctness.impl.capnproto;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.impl.capnproto.CapnprotoOptimizedSerializer;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;
import ru.siksmfp.serialization.harness.state.impl.capnproto.CapnprotoOptimizedUserState;

public class CapnprotoOptimizedSerializationTest extends ParentSerializationTest<User> {

    CapnprotoOptimizedSerializationTest() {
        super(new CapnprotoOptimizedSerializer(), new CapnprotoOptimizedUserState(), new InputUserState());
    }
}
