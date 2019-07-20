package ru.siksmfp.serialization.harness.model.converter.impl;

import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.proto.UserProto;
import ru.siksmfp.serialization.harness.model.standart.User;

public class FlatBufferaConverter implements Converter<UserProto.User, User> {

    @Override
    public UserProto.User toModel(User dto) {
        return null;
    }

    @Override
    public User toDto(UserProto.User model) {
        return null;
    }
}
