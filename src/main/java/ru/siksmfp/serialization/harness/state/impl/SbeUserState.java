package ru.siksmfp.serialization.harness.state.impl;

import org.agrona.concurrent.UnsafeBuffer;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.sbe.MessageHeaderEncoder;
import ru.siksmfp.serialization.harness.model.sbe.UserEncoder;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

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

@State(Scope.Benchmark)
public class SbeUserState implements BenchmarkState<UserEncoder, UnsafeBuffer> {

    private UserEncoder user;
    private UnsafeBuffer serializedUser;

    @Override
    public UserEncoder getInputObject() {
        return user;
    }

    @Override
    public byte[] getOutputObject() {
        return serializedUser;
    }

    @Setup(Level.Trial)
    @Override
    public void setUp() {

        serializedUser = new UnsafeBuffer();
        serializedUser.wrap(ByteBuffer.allocateDirect(1024));

        user = new UserEncoder();
        user.wrapAndApplyHeader(serializedUser, 0, new MessageHeaderEncoder());

        user.name(NAME);
        user.signature(new String(SIGNATURE));

        UserEncoder.AddressesEncoder addresses = user.addressesCount(5);

        addresses.id(ID_1);
        addresses.population(MOSCOW_POPULATION);
        addresses.city(MOSCOW_CITY);
        addresses.next();

        addresses.id(ID_2);
        addresses.population(SPB_POPULATION);
        addresses.city(SPB_CITY);
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

    }
}
