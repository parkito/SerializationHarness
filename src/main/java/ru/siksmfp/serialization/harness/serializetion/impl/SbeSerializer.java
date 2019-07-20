package ru.siksmfp.serialization.harness.serializetion.impl;

import org.agrona.concurrent.UnsafeBuffer;
import org.capnproto.MessageBuilder;
import ru.siksmfp.serialization.harness.model.converter.api.Converter;
import ru.siksmfp.serialization.harness.model.converter.impl.SbeConverter;
import ru.siksmfp.serialization.harness.model.sbe.MessageHeaderEncoder;
import ru.siksmfp.serialization.harness.model.sbe.UserDecoder;
import ru.siksmfp.serialization.harness.model.sbe.UserEncoder;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;

import java.nio.ByteBuffer;

import static ru.siksmfp.serialization.harness.state.StateConstant.ID_1;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_5;
import static ru.siksmfp.serialization.harness.state.StateConstant.MOSCOW_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.NAME;
import static ru.siksmfp.serialization.harness.state.StateConstant.SIGNATURE;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.VLADIVASTOK_POPULATION;

public class SbeSerializer implements Serializer<User> {

    private Converter<MessageBuilder, User> converter = new SbeConverter();

    @Override
    public byte[] serialize(User dto) {

        UnsafeBuffer unsafeBuffer;
        unsafeBuffer = new UnsafeBuffer();
        unsafeBuffer.wrap(ByteBuffer.allocateDirect(1024));

        UserEncoder userEncoder = new UserEncoder();
        userEncoder.wrapAndApplyHeader(unsafeBuffer, 0, new MessageHeaderEncoder());

        userEncoder.signature(new String(SIGNATURE));
        userEncoder.name(NAME);

        UserEncoder.AddressesEncoder addresses = userEncoder.addressesCount(5);

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
        addresses.next();

        return userEncoder.buffer().byteArray();
    }

    @Override
    public User deSerialize(byte[] bytes) {
        UserDecoder userDecoder = new UserDecoder();
        userDecoder.wrap(state.getOutputObject(), 8, 208, 1);
        return userDecoder.toString();    }
}
