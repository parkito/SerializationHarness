package ru.siksmfp.serialization.harness.model.converter.impl;

import org.agrona.concurrent.UnsafeBuffer;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.sbe.UserDecoder;
import ru.siksmfp.serialization.harness.model.standart.Address;
import ru.siksmfp.serialization.harness.model.standart.User;

import java.util.ArrayList;
import java.util.List;

public class SbeDecoderConverter implements Converter<UnsafeBuffer, User> {

    @Override
    public UnsafeBuffer toModel(User dto) {
        throw new IllegalStateException("There is no need to convert DTO to unsafe buffer");
    }

    @Override
    public User toDto(UnsafeBuffer buffer) {
        User dto = new User();
        UserDecoder userDecoder = new UserDecoder();
        userDecoder.wrap(buffer, 8, 208, 1);

        dto.setId(userDecoder.id());
        dto.setName(userDecoder.name());
        dto.setSignature(userDecoder.signature().getBytes());

        UserDecoder.AddressesDecoder addresses = userDecoder.addresses();
        List<Address> dtoAddresses = new ArrayList<>(addresses.count());

        for (UserDecoder.AddressesDecoder address : addresses) {
            Address dtoAddress = new Address();

            dtoAddress.setId(address.id());
            dtoAddress.setCity(address.city());
            dtoAddress.setPopulation(address.population());
            dtoAddresses.add(dtoAddress);
        }

        dto.setAddresses(dtoAddresses);

        return dto;
    }
}
