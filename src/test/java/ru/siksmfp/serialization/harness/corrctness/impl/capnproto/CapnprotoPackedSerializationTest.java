package ru.siksmfp.serialization.harness.corrctness.impl.capnproto;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.impl.capnproto.CapnprotoPackedSerializer;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;
import ru.siksmfp.serialization.harness.state.impl.capnproto.CapnprotoPackedUserState;

public class CapnprotoPackedSerializationTest extends ParentSerializationTest<User> {

    CapnprotoPackedSerializationTest() {
        super(new CapnprotoPackedSerializer(), new CapnprotoPackedUserState(), new InputUserState());
    }
}
