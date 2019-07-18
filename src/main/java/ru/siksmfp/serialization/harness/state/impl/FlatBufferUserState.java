package ru.siksmfp.serialization.harness.state.impl;

import com.google.protobuf.ByteString;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.proto.UserProto;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

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
public class FlatBufferUserState implements BenchmarkState {

    public UserProto.User user;
    public byte[] serializedUser;

    @Setup(Level.Trial)
    @Override
    public void setUp() {
        UserProto.Address address1 = UserProto.Address.newBuilder()
                .setId(ID_1)
                .setCity(MOSCOW_CITY)
                .setPopulation(MOSCOW_POPULATION)
                .build();

        UserProto.Address address2 = UserProto.Address.newBuilder()
                .setId(ID_2)
                .setCity(SPB_CITY)
                .setPopulation(SPB_POPULATION)
                .build();

        UserProto.Address address3 = UserProto.Address.newBuilder()
                .setId(ID_3)
                .setCity(DZRERZHINSK_CITY)
                .setPopulation(DZRERZHINSK_POPULATION)
                .build();

        UserProto.Address address4 = UserProto.Address.newBuilder()
                .setId(ID_4)
                .setCity(VLADIVASTOK_CITY)
                .setPopulation(VLADIVASTOK_POPULATION)
                .build();

        UserProto.Address address5 = UserProto.Address.newBuilder()
                .setId(ID_5)
                .setCity(TOKIO_CITY)
                .setPopulation(TOKIO_POPULATION)
                .build();

        user = UserProto.User
                .newBuilder()
                .setId(ID_1)
                .setName(NAME)
                .addAddresses(address1)
                .addAddresses(address2)
                .addAddresses(address3)
                .addAddresses(address4)
                .addAddresses(address5)
                .setSignature(ByteString.copyFrom(SIGNATURE))
                .build();

        serializedUser = user.toByteArray();
    }
}
