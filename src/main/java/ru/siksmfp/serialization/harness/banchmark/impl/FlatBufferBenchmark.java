package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.state.impl.FlatBufferUserState;

public class FlatBufferBenchmark extends ParentBenchmark<FlatBufferUserState> {

    @Override
    @Benchmark
    public byte[] serializationBenchmark(FlatBufferUserState state) {
        return performSerialization(state);
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(FlatBufferUserState state) {
        return performDeSerialization(state);
    }
}

// java 8
//    Benchmark                                     Mode  Cnt    Score    Error  Units
//    FlatBufferBenchmark.deSerializationBenchmark  avgt   10  442.000 ± 33.434  ns/op
//    FlatBufferBenchmark.serializationBenchmark    avgt   10  199.794 ± 10.473  ns/op
