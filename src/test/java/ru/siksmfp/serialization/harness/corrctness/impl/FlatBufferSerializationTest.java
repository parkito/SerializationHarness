package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.serializer.impl.FlatBufferSerializer;
import ru.siksmfp.serialization.harness.state.impl.FlatBufferUserState;

public class FlatBufferSerializationTest extends ParentSerializationTest {

    FlatBufferSerializationTest() {
        super(new FlatBufferSerializer(), new FlatBufferUserState());
    }
}
