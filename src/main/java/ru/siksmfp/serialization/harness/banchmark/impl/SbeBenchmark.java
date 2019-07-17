package ru.siksmfp.serialization.harness.banchmark.impl;

import org.agrona.concurrent.UnsafeBuffer;
import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.sbe.MessageHeaderEncoder;
import ru.siksmfp.serialization.harness.model.sbe.UserDecoder;
import ru.siksmfp.serialization.harness.model.sbe.UserEncoder;
import ru.siksmfp.serialization.harness.state.impl.SbeUserState;

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

public class SbeBenchmark extends ParentBenchmark<SbeUserState, String> {

//    @Benchmark
    @Override
    public byte[] serializationBenchmark(SbeUserState state) {
        UnsafeBuffer unsafeBuffer = new UnsafeBuffer();
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

//    @Benchmark
    @Override
    public String deSerializationBenchmark(SbeUserState state) {
        UserDecoder userDecoder = new UserDecoder();
        userDecoder.wrap(state.unsafeBuffer, 8, 208, 1);
        return userDecoder.toString();
    }
}

//java 8

//    Benchmark                              Mode  Cnt     Score     Error  Units
//    SbeBenchmark.deSerializationBenchmark  avgt   10   796.330 ±  68.448  ns/op
//    SbeBenchmark.serializationBenchmark    avgt   10  1221.958 ± 115.757  ns/op

