package ru.siksmfp.serialization.harness.serializetion.impl;

import org.agrona.concurrent.UnsafeBuffer;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.converter.impl.SbeDecoderConverter;
import ru.siksmfp.serialization.harness.model.converter.impl.SbeEncoderConverter;
import ru.siksmfp.serialization.harness.model.sbe.UserEncoder;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;

public class SbeSerializer implements Serializer<User> {

    private Converter<UserEncoder, User> userEncoderConverter = new SbeEncoderConverter();
    private Converter<UnsafeBuffer, User> userDecoderConverter = new SbeDecoderConverter();

    @Override
    public byte[] serialize(User dto) {
        return userEncoderConverter.toModel(dto)
                .buffer()
                .byteArray();
    }

    @Override
    public User deSerialize(byte[] bytes) {
        UnsafeBuffer buffer = new UnsafeBuffer();
        buffer.wrap(bytes);
        return userDecoderConverter.toDto(buffer);
    }
}
