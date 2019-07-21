package ru.siksmfp.serialization.harness.banchmark.impl;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;
import ru.siksmfp.serialization.harness.state.impl.CapnprotoPackedUserState;

public class CapnprotoPackedBenchmark extends ParentBenchmark<CapnprotoPackedUserState> {

    @Benchmark
    @Override
    public byte[] serializationBenchmark(CapnprotoPackedUserState state) {
        Serializer<User> serializer = state.getSerializer();
        return serializer.serialize(state.getInputObject());
    }

    @Benchmark
    @Override
    public User deSerializationBenchmark(CapnprotoPackedUserState state) {
        Serializer<User> serializer = state.getSerializer();
        return serializer.deSerialize(state.getOutputObject());
    }
}
