package ru.siksmfp.serialization.harness.serializer.impl;

import ru.siksmfp.serialization.harness.converter.impl.CoflerConverter;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;

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
        ru.siksmfp.serialization.harness.dto.cofler.User user = new ru.siksmfp.serialization.harness.dto.cofler.User();
        user.unmarshal(bytes, 0);
        return coflerConverter.toDto(user);
    }
}
