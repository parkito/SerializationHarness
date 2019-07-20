package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;
import ru.siksmfp.serialization.harness.serializetion.impl.CapnprotoSerializer;
import ru.siksmfp.serialization.harness.state.impl.CapnprotoUserState;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;

public class CapnprotoBenchmark extends ParentBenchmark<CapnprotoUserState> {

    private Serializer<User> serializer = new CapnprotoSerializer();

    @Benchmark
    @Override
    public byte[] serializationBenchmark(InputUserState state) {
        return serializer.serialize(state.getInputObject());
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(CapnprotoUserState state) {
        return serializer.deSerialize(state.getOutputObject());
    }
}

//java 8
//    Benchmark                                    Mode  Cnt    Score    Error  Units
//    CapnprotoBenchmark.deSerializationBenchmark  avgt   10  139.210 ± 24.013  ns/op
//    CapnprotoBenchmark.serializationBenchmark    avgt   10  140.925 ± 17.287  ns/op

