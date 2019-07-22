package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.impl.FlatBufferSerializer;
import ru.siksmfp.serialization.harness.state.impl.FlatBufferUserState;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;

public class FlatBufferSerializationTest extends ParentSerializationTest<User> {

    FlatBufferSerializationTest() {
        super(new FlatBufferSerializer(), new FlatBufferUserState(), new InputUserState());
    }
}
