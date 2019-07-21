package ru.siksmfp.serialization.harness.model.converter.impl;

import org.agrona.concurrent.UnsafeBuffer;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.sbe.UserDecoder;
import ru.siksmfp.serialization.harness.model.sbe.UserEncoder;
import ru.siksmfp.serialization.harness.model.standart.Address;
import ru.siksmfp.serialization.harness.model.standart.User;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class SbeConverter implements Converter<UnsafeBuffer, User> {

    @Override
    public UnsafeBuffer toModel(User dto) {
        UnsafeBuffer unsafeBuffer = new UnsafeBuffer();
        unsafeBuffer.wrap(ByteBuffer.allocateDirect(1024));

        UserEncoder userEncoder = new UserEncoder();
        userEncoder.wrap(unsafeBuffer, 0);

        List<Address> dtoAddresses = dto.getAddresses();
        int addressesSize = dtoAddresses.size();

        UserEncoder.AddressesEncoder addresses = userEncoder.addressesCount(addressesSize).next();

        for (int i = 0; i < addressesSize; i++) {
            Address dtoAddress = dtoAddresses.get(i);

            addresses.id(dtoAddress.getId());
            addresses.city(dtoAddress.getCity());
            addresses.population(dtoAddress.getPopulation());

            if (i < addressesSize - 1)
                addresses.next();
        }

        userEncoder.id(dto.getId());
        userEncoder.name(dto.getName());
        userEncoder.signature(new String(dto.getSignature()));

        return unsafeBuffer;
    }

    @Override
    public User toDto(UnsafeBuffer buffer) {
        User dto = new User();
        UserDecoder userDecoder = new UserDecoder();
        userDecoder.wrap(buffer, 0, 208, 1);

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
