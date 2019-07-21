package ru.siksmfp.serialization.harness.serializer.impl;

import org.agrona.concurrent.UnsafeBuffer;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.converter.impl.SbeConverter;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;

import java.nio.ByteBuffer;

public class SbeSerializer implements Serializer<User> {

    private Converter<UnsafeBuffer, User> converter = new SbeConverter();

    @Override
    public byte[] serialize(User dto) {
        ByteBuffer byteBuffer = converter.toModel(dto).byteBuffer();
        byte[] arr = new byte[byteBuffer.remaining()];
        byteBuffer.get(arr);

        return arr;

    }

    @Override
    public User deSerialize(byte[] bytes) {
        UnsafeBuffer buffer = new UnsafeBuffer();
        buffer.wrap(bytes);
        return converter.toDto(buffer);
    }
}
