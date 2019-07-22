package ru.siksmfp.serialization.harness.banchmark.impl.capnproto;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.state.impl.capnproto.CapnprotoOptimizedUserState;

public class CapnprotoOptimizedBenchmark extends ParentBenchmark<User, CapnprotoOptimizedUserState> {

    @Benchmark
    @Override
    public byte[] serializationBenchmark(CapnprotoOptimizedUserState state) {
        return performSerialization(state);
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(CapnprotoOptimizedUserState state) {
        return performDeSerialization(state);
    }
}

//java 8
//    Benchmark                                    Mode  Cnt    Score    Error  Units
//    CapnprotoBenchmark.deSerializationBenchmark  avgt   10  139.210 ± 24.013  ns/op
//    CapnprotoBenchmark.serializationBenchmark    avgt   10  140.925 ± 17.287  ns/op

