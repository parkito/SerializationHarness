package ru.siksmfp.serialization.harness.banchmark;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.proto.UserProto;

public class FlatBufferBenchmark extends ParentBenchmark {

    @State(Scope.Benchmark)
    public static class FlatBufferUserState {
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

    @Benchmark
    public byte[] serializationBenchmark(FlatBufferUserState state) {
        return state.userProto.toByteArray();
    }

    @Benchmark
    public UserProto.User deSerializationBenchmark(FlatBufferUserState state) {
        try {
            return UserProto.User.parseFrom(state.serializedUser);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    }

    // java 8
//    Benchmark                                     Mode  Cnt    Score    Error  Units
//    FlatBufferBenchmark.deSerializationBenchmark  avgt   10  442.000 ± 33.434  ns/op
//    FlatBufferBenchmark.serializationBenchmark    avgt   10  199.794 ± 10.473  ns/op
}
