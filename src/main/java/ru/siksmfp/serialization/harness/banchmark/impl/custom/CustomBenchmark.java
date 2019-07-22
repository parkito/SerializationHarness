package ru.siksmfp.serialization.harness.banchmark.impl.custom;

import org.openjdk.jmh.annotations.Benchmark;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.model.custom.CustomModel;
import ru.siksmfp.serialization.harness.state.impl.custom.CustomState;

public class CustomBenchmark extends ParentBenchmark<CustomModel, CustomState> {

    @Override
    @Benchmark
    public byte[] serializationBenchmark(CustomState state) {
        return performSerialization(state);
    }

    @Override
    @Benchmark
    public CustomModel deSerializationBenchmark(CustomState state) {
        return performDeSerialization(state);
    }
}
