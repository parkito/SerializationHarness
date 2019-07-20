package ru.siksmfp.serialization.harness.model.converter.impl;

import ru.siksmfp.serialization.harness.model.cofler.User;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;

public class CoflerConverter implements Converter<User,ru.siksmfp.serialization.harness.model.standart.User> {

    @Override
    public User toModel(ru.siksmfp.serialization.harness.model.standart.User dto) {
        return null;
    }

    @Override
    public ru.siksmfp.serialization.harness.model.standart.User toDto(User model) {
        return null;
    }
}
