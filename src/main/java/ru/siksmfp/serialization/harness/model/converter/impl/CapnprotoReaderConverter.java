package ru.siksmfp.serialization.harness.model.converter.impl;

import org.capnproto.MessageReader;
import ru.siksmfp.serialization.harness.model.capnp.UserModel;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.standart.Address;
import ru.siksmfp.serialization.harness.model.standart.User;

import java.util.ArrayList;
import java.util.List;

public class CapnprotoReaderConverter implements Converter<MessageReader, User> {

    @Override
    public MessageReader toModel(User dto) {
        throw new IllegalStateException("There is no need to convert DTO into message reader");
    }

    @Override
    public User toDto(MessageReader model) {
        User dto = new User();
        UserModel.User.Reader userReader = model.getRoot(UserModel.User.factory);
        List<Address> addresses = new ArrayList<>();

        dto.setId(userReader.getId());
        dto.setName(userReader.getName().toString());
        dto.setSignature(userReader.getSignature().toArray());

        for (UserModel.Address.Reader addressReader : userReader.getAddresses()) {
            Address address = new Address();

            address.setId(addressReader.getId());
            address.setCity(addressReader.getCity().toString());
            address.setPopulation(addressReader.getPopulation());

            addresses.add(address);
        }

        dto.setAddresses(addresses);

        return dto;
    }
}
