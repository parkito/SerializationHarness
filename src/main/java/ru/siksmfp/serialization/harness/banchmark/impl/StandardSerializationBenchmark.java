package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializetion.api.Serializer;
import ru.siksmfp.serialization.harness.serializetion.impl.StandardSerializer;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;
import ru.siksmfp.serialization.harness.state.impl.StandardUserState;

public class StandardSerializationBenchmark extends ParentBenchmark<StandardUserState> {

    private Serializer<User> serializer = new StandardSerializer();

    @Benchmark
    public byte[] serializationBenchmark(InputUserState state) {
        return serializer.serialize(state.getInputObject());
    }

    @Benchmark
    public User deSerializationBenchmark(StandardUserState state) {
        return serializer.deSerialize(state.getOutputObject().array());
    }
}

//    java 8
//    Benchmark                                                Mode  Cnt      Score      Error  Units
//    StandardSerializationBenchmark.deSerializationBenchmark  avgt   10  22148.122 ± 3252.490  ns/op
//    StandardSerializationBenchmark.serializationBenchmark    avgt   10   4313.692 ±  446.117  ns/op

//java11
//    StandardSerializationBenchmark.deSerializationBenchmark  avgt   10  25613.718 ± 5648.547  ns/op
//    StandardSerializationBenchmark.serializationBenchmark    avgt   10   4483.647 ±  926.454  ns/op

