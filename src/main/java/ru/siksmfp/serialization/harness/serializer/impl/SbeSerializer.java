package ru.siksmfp.serialization.harness.serializer.impl;

import org.agrona.concurrent.UnsafeBuffer;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.converter.impl.SbeConverter;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;

public class SbeSerializer implements Serializer<User> {

    private Converter<UnsafeBuffer, User> converter = new SbeConverter();

    @Override
    public byte[] serialize(User dto) {
        return converter.toModel(dto).byteBuffer().array();
    }

    @Override
    public User deSerialize(byte[] bytes) {
        return converter.toDto(new UnsafeBuffer(bytes));
    }
}
