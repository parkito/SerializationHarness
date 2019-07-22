package ru.siksmfp.serialization.harness.corrctness.impl;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.impl.CoflerSerializer;
import ru.siksmfp.serialization.harness.state.impl.CoflerUserState;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;

public class CoflerSerializationTest extends ParentSerializationTest<User> {

    CoflerSerializationTest() {
        super(new CoflerSerializer(), new CoflerUserState(), new InputUserState());
    }
}
