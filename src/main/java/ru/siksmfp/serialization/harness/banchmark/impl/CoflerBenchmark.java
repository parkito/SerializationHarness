package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.state.impl.CoflerUserState;

public class CoflerBenchmark extends ParentBenchmark<User, CoflerUserState> {

    @Benchmark
    @Override
    public byte[] serializationBenchmark(CoflerUserState state) {
        return performSerialization(state);
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(CoflerUserState state) {
        return performDeSerialization(state);
    }

    //java 8

//    Benchmark                                 Mode  Cnt    Score     Error  Units
//    CoflerBenchmark.deSerializationBenchmark  avgt   10  285.095 ±  84.780  ns/op
//    CoflerBenchmark.serializationBenchmark    avgt   10  539.067 ± 243.713  ns/op
}