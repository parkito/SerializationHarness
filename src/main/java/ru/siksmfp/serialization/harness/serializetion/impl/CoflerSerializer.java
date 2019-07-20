package ru.siksmfp.serialization.harness.serializetion.impl;

import ru.siksmfp.serialization.harness.model.converter.impl.CoflerConverter;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;

public class CoflerSerializer implements Serializer<User> {

    private CoflerConverter coflerConverter = new CoflerConverter();

    @Override
    public byte[] serialize(User dto) {
        byte[] bytes = new byte[1024];
        coflerConverter.toModel(dto).marshal(bytes, 0);
        return bytes;
    }

    @Override
    public User deSerialize(byte[] bytes) {
        ru.siksmfp.serialization.harness.model.cofler.User user = new ru.siksmfp.serialization.harness.model.cofler.User();
        user.unmarshal(bytes, 0);
        return coflerConverter.toDto(user);
    }
}