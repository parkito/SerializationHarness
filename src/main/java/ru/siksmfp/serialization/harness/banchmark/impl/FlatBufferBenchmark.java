package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;
import ru.siksmfp.serialization.harness.serializetion.impl.FlatBufferSerializer;
import ru.siksmfp.serialization.harness.state.impl.FlatBufferUserState;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;

public class FlatBufferBenchmark extends ParentBenchmark<FlatBufferUserState> {

    private Serializer<User> serializer = new FlatBufferSerializer();

    @Benchmark
    @Override
    public byte[] serializationBenchmark(InputUserState state) {
        return serializer.serialize(state.getInputObject());
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(FlatBufferUserState state) {
        return serializer.deSerialize(state.getOutputObject());
    }
}

// java 8
//    Benchmark                                     Mode  Cnt    Score    Error  Units
//    FlatBufferBenchmark.deSerializationBenchmark  avgt   10  442.000 ± 33.434  ns/op
//    FlatBufferBenchmark.serializationBenchmark    avgt   10  199.794 ± 10.473  ns/op
