package ru.siksmfp.serialization.harness.corrctness.impl.capnproto;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.impl.capnproto.CapnprotoSerializer;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;
import ru.siksmfp.serialization.harness.state.impl.capnproto.CapnprotoUserState;

public class CapnprotoSerializationTest extends ParentSerializationTest<User> {

    CapnprotoSerializationTest() {
        super(new CapnprotoSerializer(), new CapnprotoUserState(), new InputUserState());
    }
}
