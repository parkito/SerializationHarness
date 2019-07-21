package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.serializer.impl.CoflerSerializer;
import ru.siksmfp.serialization.harness.state.impl.CoflerUserState;


public class CoflerSerializationTest extends ParentSerializationTest {

    CoflerSerializationTest() {
        super(new CoflerSerializer(), new CoflerUserState());
    }
}
