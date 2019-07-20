package ru.siksmfp.serialization.harness.model.converter.impl;

import ru.siksmfp.serialization.harness.model.cofler.Address;
import ru.siksmfp.serialization.harness.model.cofler.User;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;

import java.util.ArrayList;
import java.util.List;

public class CoflerConverter implements Converter<User, ru.siksmfp.serialization.harness.model.standart.User> {

    @Override
    public User toModel(ru.siksmfp.serialization.harness.model.standart.User dto) {
        User user = new User();

        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSignature(dto.getSignature());

        List<ru.siksmfp.serialization.harness.model.standart.Address> addresses = dto.getAddresses();
        Address[] coflerAddresses = new Address[addresses.size()];

        for (int i = 0; i < addresses.size(); i++) {
            ru.siksmfp.serialization.harness.model.standart.Address dtoAddress = addresses.get(i);
            Address address = new Address();

            address.setId(dtoAddress.getId());
            address.setCity(dtoAddress.getCity());
            address.setPopulation(dtoAddress.getPopulation());
            coflerAddresses[i] = address;
        }

        user.setAddresses(coflerAddresses);

        return user;
    }

    @Override
    public ru.siksmfp.serialization.harness.model.standart.User toDto(User model) {
        ru.siksmfp.serialization.harness.model.standart.User dto = new ru.siksmfp.serialization.harness.model.standart.User();

        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setSignature(model.getSignature());

        Address[] coflerAddresses = model.getAddresses();
        List<ru.siksmfp.serialization.harness.model.standart.Address> addresses = new ArrayList<>(coflerAddresses.length);

        for (Address coflerAddress : coflerAddresses) {
            ru.siksmfp.serialization.harness.model.standart.Address address = new ru.siksmfp.serialization.harness.model.standart.Address();

            address.setId(coflerAddress.getId());
            address.setCity(coflerAddress.getCity());
            address.setPopulation(coflerAddress.getPopulation());
            addresses.add(address);
        }

        dto.setAddresses(addresses);

        return dto;
    }
}
