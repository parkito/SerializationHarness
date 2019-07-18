package ru.siksmfp.serialization.harness.banchmark.impl;

import com.google.protobuf.InvalidProtocolBufferException;
import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.proto.UserProto;
import ru.siksmfp.serialization.harness.state.impl.FlatBufferUserState;

public class FlatBufferBenchmark extends ParentBenchmark<FlatBufferUserState, UserProto.User> {

    @Benchmark
    @Override
    public byte[] serializationBenchmark(FlatBufferUserState state) {
        return state.getInputObject().toByteArray();
    }

    @Benchmark
    @Override
    public UserProto.User deSerializationBenchmark(FlatBufferUserState state) {
        try {
            return UserProto.User.parseFrom(state.getOutputObject());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// java 8
//    Benchmark                                     Mode  Cnt    Score    Error  Units
//    FlatBufferBenchmark.deSerializationBenchmark  avgt   10  442.000 ± 33.434  ns/op
//    FlatBufferBenchmark.serializationBenchmark    avgt   10  199.794 ± 10.473  ns/op
