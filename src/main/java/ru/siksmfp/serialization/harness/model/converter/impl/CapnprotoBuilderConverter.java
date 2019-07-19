package ru.siksmfp.serialization.harness.model.converter.impl;

import org.capnproto.MessageBuilder;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.standart.User;

public class CapnprotoBuilderConverter implements Converter<MessageBuilder, User> {

    @Override
    public MessageBuilder toModel(User dto) {
        return null;
    }

    @Override
    public User toDto(MessageBuilder model) {
        return null;
    }
}
