package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.state.impl.CapnprotoPackedUserState;

public class CapnprotoPackedBenchmark extends ParentBenchmark<User,CapnprotoPackedUserState> {

    @Benchmark
    @Override
    public byte[] serializationBenchmark(CapnprotoPackedUserState state) {
        return performSerialization(state);
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(CapnprotoPackedUserState state) {
        return performDeSerialization(state);
    }
}
