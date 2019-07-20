package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;
import ru.siksmfp.serialization.harness.state.impl.SbeUserState;

public class SbeBenchmark extends ParentBenchmark<SbeUserState> {

    @Override
    public byte[] serializationBenchmark(SbeUserState state) {
        Serializer<User> serializer = state.getSerializer();
        return serializer.serialize(state.getInputObject());
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(SbeUserState state) {
        Serializer<User> serializer = state.getSerializer();
        return serializer.deSerialize(state.getOutputObject());
    }
}

//java 8
//    Benchmark                              Mode  Cnt     Score     Error  Units
//    SbeBenchmark.deSerializationBenchmark  avgt   10   796.330 ±  68.448  ns/op
//    SbeBenchmark.serializationBenchmark    avgt   10  1221.958 ± 115.757  ns/op

