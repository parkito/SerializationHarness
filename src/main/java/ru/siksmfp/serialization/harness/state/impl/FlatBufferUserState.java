package ru.siksmfp.serialization.harness.state.impl;

import com.google.protobuf.ByteString;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.proto.UserProto;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

import static ru.siksmfp.serialization.harness.state.StateConstant.DZRERZHINSK_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_1;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_2;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_3;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_4;
import static ru.siksmfp.serialization.harness.state.StateConstant.ID_5;
import static ru.siksmfp.serialization.harness.state.StateConstant.MOSCOW_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.SPB_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.TOKIO_CITY;
import static ru.siksmfp.serialization.harness.state.StateConstant.VLADIVASTOK_CITY;

@State(Scope.Benchmark)
public class FlatBufferUserState implements BenchmarkState {

    public UserProto.User userProto;
    public byte[] serializedUser;

    @Setup(Level.Trial)
    @Override
    public void setUp() {
        UserProto.Address address1 = UserProto.Address.newBuilder()
                .setId(ID_1)
                .setCity(MOSCOW_CITY)
                .setPopulation(15_000_000)
                .build();

        UserProto.Address address2 = UserProto.Address.newBuilder()
                .setId(ID_2)
                .setCity(SPB_CITY)
                .setPopulation(5_000_000)
                .build();

        UserProto.Address address3 = UserProto.Address.newBuilder()
                .setId(ID_3)
                .setCity(DZRERZHINSK_CITY)
                .setPopulation(250_000)
                .build();

        UserProto.Address address4 = UserProto.Address.newBuilder()
                .setId(ID_4)
                .setCity(VLADIVASTOK_CITY)
                .setPopulation(1_000_000)
                .build();

        UserProto.Address address5 = UserProto.Address.newBuilder()
                .setId(ID_5)
                .setCity(TOKIO_CITY)
                .setPopulation(30_000_000)
                .build();

        userProto = UserProto.User
                .newBuilder()
                .setId(1)
                .setName("name")
                .addAddresses(address1)
                .addAddresses(address2)
                .addAddresses(address3)
                .addAddresses(address4)
                .addAddresses(address5)
                .setSignature(ByteString.copyFrom("longUniqGoodUserSignatureForSecurity".getBytes()))
                .build();

        serializedUser = userProto.toByteArray();
    }
}
