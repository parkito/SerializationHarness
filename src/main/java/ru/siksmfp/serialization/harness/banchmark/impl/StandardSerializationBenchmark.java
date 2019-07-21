package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.state.impl.StandardUserState;

public class StandardSerializationBenchmark extends ParentBenchmark<StandardUserState> {

    @Override
    @Benchmark
    public byte[] serializationBenchmark(StandardUserState state) {
        return performSerialization(state);
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(StandardUserState state) {
        return performDeSerialization(state);
    }
}

//    java 8
//    Benchmark                                                Mode  Cnt      Score      Error  Units
//    StandardSerializationBenchmark.deSerializationBenchmark  avgt   10  22148.122 ± 3252.490  ns/op
//    StandardSerializationBenchmark.serializationBenchmark    avgt   10   4313.692 ±  446.117  ns/op

//java11
//    StandardSerializationBenchmark.deSerializationBenchmark  avgt   10  25613.718 ± 5648.547  ns/op
//    StandardSerializationBenchmark.serializationBenchmark    avgt   10   4483.647 ±  926.454  ns/op

