package ru.siksmfp.serialization.harness.serializer.impl.custom;

import ru.siksmfp.serialization.harness.dto.custom.CustomDto;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;

public class CustomSerializer implements Serializer<CustomDto> {
    @Override
    public byte[] serialize(CustomDto dto) {
        return new byte[0];
    }

    @Override
    public CustomDto deSerialize(byte[] bytes) {
        return null;
    }
}
