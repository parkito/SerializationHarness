package ru.siksmfp.serialization.harness.state.impl;

import com.google.protobuf.ByteString;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.proto.UserProto;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

@State(Scope.Benchmark)
public class FlatBufferUserState implements BenchmarkState {

    public UserProto.User userProto;
    public byte[] serializedUser;

    @Setup(Level.Trial)
    public void setUp() {
        UserProto.Address address1 = UserProto.Address.newBuilder()
                .setId(1)
                .setCity("Moscow")
                .setPopulation(15_000_000)
                .build();

        UserProto.Address address2 = UserProto.Address.newBuilder()
                .setId(2)
                .setCity("SPB")
                .setPopulation(5_000_000)
                .build();

        UserProto.Address address3 = UserProto.Address.newBuilder()
                .setId(3)
                .setCity("Dzerzhinsk")
                .setPopulation(250_000)
                .build();

        UserProto.Address address4 = UserProto.Address.newBuilder()
                .setId(4)
                .setCity("Vladivastok")
                .setPopulation(1_000_000)
                .build();

        UserProto.Address address5 = UserProto.Address.newBuilder()
                .setId(5)
                .setCity("Tokio")
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