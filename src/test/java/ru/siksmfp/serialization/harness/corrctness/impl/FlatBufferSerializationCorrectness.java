package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.serializetion.impl.FlatBufferSerializer;
import ru.siksmfp.serialization.harness.state.impl.FlatBufferUserState;

public class FlatBufferSerializationCorrectness extends ParentSerializationTest {

    FlatBufferSerializationCorrectness() {
        super(new FlatBufferSerializer(), new FlatBufferUserState());
    }
}
