package ru.siksmfp.serialization.harness.banchmark.impl;

import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

public class SbeBenchmark extends ParentBenchmark {
    @Override
    protected byte[] serializationBenchmark(BenchmarkState state) {
        return new byte[0];
    }

    @Override
    protected Object deSerializationBenchmark(BenchmarkState state) {
        return null;
    }
}
