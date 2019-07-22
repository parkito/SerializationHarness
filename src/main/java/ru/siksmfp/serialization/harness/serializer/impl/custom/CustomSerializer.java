package ru.siksmfp.serialization.harness.serializer.impl.custom;

import ru.siksmfp.serialization.harness.dto.custom.CustomDto;
import ru.siksmfp.serialization.harness.model.custom.CustomModel;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;

public class CustomSerializer implements Serializer<CustomModel> {
    @Override
    public byte[] serialize(CustomModel dto) {
        return new byte[0];
    }

    @Override
    public CustomModel deSerialize(byte[] bytes) {
        return null;
    }
}
