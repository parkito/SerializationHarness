package ru.siksmfp.serialization.harness.serializetion.impl;

import com.google.protobuf.InvalidProtocolBufferException;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.converter.impl.FlatBufferConverter;
import ru.siksmfp.serialization.harness.model.proto.UserProto;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;

public class FlatBufferSerializer implements Serializer<User> {

    private Converter<UserProto.User, User> converter = new FlatBufferConverter();

    @Override
    public byte[] serialize(User dto) {
        return converter.toModel(dto).toByteArray();
    }

    @Override
    public User deSerialize(byte[] bytes) {
        try {
            return converter.toDto(UserProto.User.parseFrom(bytes));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    }
}
