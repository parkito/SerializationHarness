package ru.siksmfp.serialization.harness.corrctness.impl.custom;

import ru.siksmfp.serialization.harness.corrctness.api.ParentSerializationTest;
import ru.siksmfp.serialization.harness.model.custom.CustomModel;
import ru.siksmfp.serialization.harness.serializer.impl.custom.CustomSerializer;
import ru.siksmfp.serialization.harness.state.impl.custom.CustomState;

public class CustomSerializationTest extends ParentSerializationTest<CustomModel> {

    CustomSerializationTest() {
        super(new CustomSerializer(), new CustomState(), new CustomState());
    }
}
