package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;
import ru.siksmfp.serialization.harness.serializetion.impl.SbeSerializer;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;
import ru.siksmfp.serialization.harness.state.impl.SbeUserState;

public class SbeBenchmark extends ParentBenchmark<SbeUserState> {

    private Serializer<User> sbeSerializer = new SbeSerializer();

    @Benchmark
    @Override
    public byte[] serializationBenchmark(InputUserState state) {
        return sbeSerializer.serialize(state.getInputObject());
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(SbeUserState state) {
        return sbeSerializer.deSerialize(state.getOutputObject());
    }
}

//java 8
//    Benchmark                              Mode  Cnt     Score     Error  Units
//    SbeBenchmark.deSerializationBenchmark  avgt   10   796.330 ±  68.448  ns/op
//    SbeBenchmark.serializationBenchmark    avgt   10  1221.958 ± 115.757  ns/op

