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

import static ru.siksmfp.serialization.harness.state.StateConstant.DZRERZHINSK_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.DZRERZHINSK_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_1;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_2;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_3;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_4;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_5;
import static ru.siksmfp.serialization.harness.state.StateConstant.MOSCOW_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.MOSCOW_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.NAME;
import static ru.siksmfp.serialization.harness.state.StateConstant.SPB_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.SPB_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.VLADIVASTOK_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.VLADIVASTOK_POPULATION;

public class SbeConverter implements Converter<UnsafeBuffer, User> {

    @Override
    public UnsafeBuffer toModel(User dto) {
        UnsafeBuffer unsafeBuffer = new UnsafeBuffer();
        unsafeBuffer.wrap(ByteBuffer.allocateDirect(1024));

        UserEncoder userEncoder = new UserEncoder();
        userEncoder.wrap(unsafeBuffer, 0);

        userEncoder.id(dto.getId());
        userEncoder.name(dto.getName());
//        userEncoder.signature(new String(dto.getSignature()));

        List<Address> dtoAddresses = dto.getAddresses();

        UserEncoder.AddressesEncoder addresses = userEncoder.addressesCount(dtoAddresses.size());

        for (Address dtoAddress : dtoAddresses) {
            addresses.id(dtoAddress.getId());
            addresses.city(dtoAddress.getCity());
            addresses.population(dtoAddress.getPopulation());
            addresses.next();
        }


        return unsafeBuffer;
    }

    @Override
    public User toDto(UnsafeBuffer buffer) {
        User dto = new User();
        UserDecoder userDecoder = new UserDecoder();
        userDecoder.wrap(buffer, 0, 208, 1);

        dto.setId(userDecoder.id());
        dto.setName(userDecoder.name());
//        dto.setSignature(userDecoder.signature().getBytes());

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

    public static void main(String[] args) throws Exception {
        UnsafeBuffer unsafeBuffer = new UnsafeBuffer();
        unsafeBuffer.wrap(ByteBuffer.allocateDirect(1024));

        UserEncoder userEncoder = new UserEncoder();
        userEncoder.wrap(unsafeBuffer, 0);

        userEncoder.id(105L);
        userEncoder.name(NAME);
        userEncoder.signature("sig");
        SbeConverter.printBuffer(unsafeBuffer);

        UserEncoder.AddressesEncoder addresses = userEncoder.addressesCount(4);

        addresses.id(ID_1);
        addresses.population(MOSCOW_POPULATION);
        addresses.city(MOSCOW_CITY);
        addresses.next();

        addresses.id(ID_2);
        addresses.city(SPB_CITY);
        addresses.population(SPB_POPULATION);
        addresses.next();

        addresses.id(ID_3);
        addresses.population(DZRERZHINSK_POPULATION);
        addresses.city(DZRERZHINSK_CITY);
        addresses.next();

        addresses.city(VLADIVASTOK_CITY);
        addresses.id(ID_4);
        addresses.population(VLADIVASTOK_POPULATION);
        addresses.next();

        addresses.id(ID_5);
        addresses.population(TOKIO_POPULATION);
        addresses.city(TOKIO_CITY);

        System.out.println(userEncoder);
    }

    public static void printBuffer(UnsafeBuffer buffer) {
        ByteBuffer byteBuffer = buffer.byteBuffer();
        byte[] arr = new byte[byteBuffer.remaining()];
        byteBuffer.get(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
