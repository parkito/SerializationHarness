package ru.siksmfp.serialization.harness.converter.impl.capnpoto;

import org.capnproto.MessageBuilder;
import org.capnproto.StructList;
import ru.siksmfp.serialization.harness.dto.capnp.UserModel;
import ru.siksmfp.serialization.harness.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.standart.Address;
import ru.siksmfp.serialization.harness.model.standart.User;

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
            Address dtoAddress = addresses.get(i);
            UserModel.Address.Builder address = addressBuilder.get(i);

            address.setId(dtoAddress.getId());
            address.setCity(dtoAddress.getCity());
            address.setPopulation(dtoAddress.getPopulation());
        }

        return messageBuilder;
    }

    @Override
    public User toDto(MessageBuilder model) {
        throw new IllegalStateException("There is no need to convert message builder into DTO");
    }
}
