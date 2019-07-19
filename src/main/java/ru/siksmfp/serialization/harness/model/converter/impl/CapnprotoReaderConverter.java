package ru.siksmfp.serialization.harness.model.converter.impl;

import org.capnproto.MessageReader;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.standart.User;

public class CapnprotoReaderConverter implements Converter<MessageReader, User> {
    @Override
    public MessageReader toModel(User dto) {
        return null;
    }

    @Override
    public User toDto(MessageReader model) {
        return null;
    }
}
