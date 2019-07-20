package ru.siksmfp.serialization.harness.model.converter.impl;

import org.capnproto.MessageBuilder;
import org.capnproto.StructList;
import ru.siksmfp.serialization.harness.model.capnp.UserModel;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.standart.Address;
import ru.siksmfp.serialization.harness.model.standart.User;

import java.util.ArrayList;
import java.util.List;

public class CapnprotoBuilderConverter implements Converter<MessageBuilder, User> {

    @Override
    public MessageBuilder toModel(User dto) {
        MessageBuilder messageBuilder = new MessageBuilder();

        UserModel.User.Builder user = messageBuilder.initRoot(UserModel.User.factory);
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSignature(dto.getSignature());

        List<Address> addresses = dto.getAddresses();

        StructList.Builder<UserModel.Address.Builder> addressBuilder = user.initAddresses(addresses.size());

        for (int i = 0; i < addresses.size(); i++) {
            final Address dtoAddress = addresses.get(i);
            UserModel.Address.Builder address = addressBuilder.get(i);

            address.setId(dtoAddress.getId());
            address.setCity(dtoAddress.getCity());
            address.setPopulation(dtoAddress.getPopulation());
        }

        return messageBuilder;
    }

    @Override
    public User toDto(MessageBuilder model) {
        User dto = new User();
        UserModel.User.Builder userReader = model.getRoot(UserModel.User.factory);

        dto.setId(userReader.getId());
        dto.setName(userReader.getName().toString());
        dto.setSignature(userReader.getSignature().toArray());

        List<Address> addresses = new ArrayList<>();

        for (UserModel.Address.Builder addressReader : userReader.getAddresses()) {
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
