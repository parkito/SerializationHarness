package ru.siksmfp.serialization.harness.model.converter.impl;

import org.agrona.concurrent.UnsafeBuffer;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.sbe.MessageHeaderEncoder;
import ru.siksmfp.serialization.harness.model.sbe.UserEncoder;
import ru.siksmfp.serialization.harness.model.standart.Address;
import ru.siksmfp.serialization.harness.model.standart.User;

import java.nio.ByteBuffer;
import java.util.List;

public class SbeEncoderConverter implements Converter<UserEncoder, User> {

    @Override
    public UserEncoder toModel(User dto) {
        UnsafeBuffer unsafeBuffer;
        unsafeBuffer = new UnsafeBuffer();
        unsafeBuffer.wrap(ByteBuffer.allocateDirect(1024));

        UserEncoder userEncoder = new UserEncoder();
        userEncoder.wrapAndApplyHeader(unsafeBuffer, 0, new MessageHeaderEncoder());

        userEncoder.id(dto.getId());
        userEncoder.name(dto.getName());
        userEncoder.signature(new String(dto.getSignature()));

        List<Address> dtoAddresses = dto.getAddresses();

        UserEncoder.AddressesEncoder addresses = userEncoder.addressesCount(dtoAddresses.size());

        for (Address dtoAddress : dtoAddresses) {
            addresses.id(dtoAddress.getId());
            addresses.city(dtoAddress.getCity());
            addresses.population(dtoAddress.getPopulation());
            addresses.next();
        }

        return userEncoder;
    }

    @Override
    public User toDto(UserEncoder model) {
        throw new IllegalStateException("There is no need to convert User encoder to DTO");
    }
}
