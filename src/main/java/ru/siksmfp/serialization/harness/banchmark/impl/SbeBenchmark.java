package ru.siksmfp.serialization.harness.banchmark.impl;

import org.agrona.concurrent.UnsafeBuffer;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.sbe.MessageHeaderEncoder;
import ru.siksmfp.serialization.harness.model.sbe.UserDecoder;
import ru.siksmfp.serialization.harness.model.sbe.UserEncoder;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;
import uk.co.real_logic.sbe.SbeTool;

import java.nio.ByteBuffer;

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
import static ru.siksmfp.serialization.harness.state.StateConstant.SIGNATURE;
import static ru.siksmfp.serialization.harness.state.StateConstant.SPB_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.SPB_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_POPULATION;
import static ru.siksmfp.serialization.harness.state.StateConstant.VLADIVASTOK_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.VLADIVASTOK_POPULATION;

public class SbeBenchmark extends ParentBenchmark {
    @Override
    protected byte[] serializationBenchmark(BenchmarkState state) {
        return new byte[0];
    }

    @Override
    protected Object deSerializationBenchmark(BenchmarkState state) {
        return null;
    }

    public static void main(String[] args) throws Exception {
//        SbeTool.main(new String[]{"/Users/parkito/GitHub/bids/SerializationHarness/src/main/resources/user.xml"});

        UnsafeBuffer unsafeBuffer = new UnsafeBuffer();
        unsafeBuffer.wrap(ByteBuffer.allocateDirect(1024));

        UserEncoder userEncoder = new UserEncoder();
        userEncoder.wrapAndApplyHeader(unsafeBuffer, 0, new MessageHeaderEncoder());

        userEncoder.name(NAME);
        userEncoder.signature(new String(SIGNATURE));

        UserEncoder.AddressesEncoder addresses = userEncoder.addressesCount(5);
        addresses.id(ID_1);
        addresses.city(MOSCOW_CITY);
        addresses.population(MOSCOW_POPULATION);
        addresses.next();

        addresses.id(ID_2);
        addresses.city(SPB_CITY);
        addresses.population(SPB_POPULATION);
        addresses.next();

        addresses.id(ID_3);
        addresses.city(DZRERZHINSK_CITY);
        addresses.population(DZRERZHINSK_POPULATION);
        addresses.next();

        addresses.id(ID_4);
        addresses.city(VLADIVASTOK_CITY);
        addresses.population(VLADIVASTOK_POPULATION);
        addresses.next();

        addresses.id(ID_5);
        addresses.city(TOKIO_CITY);
        addresses.population(TOKIO_POPULATION);
        addresses.next();

        System.out.println(userEncoder);

        UserDecoder userDecoder = new UserDecoder();
        userDecoder.wrap(userEncoder.buffer(), 8, 208, 1);
        System.out.println(userDecoder.name());
        System.out.println(userDecoder);

    }
}
