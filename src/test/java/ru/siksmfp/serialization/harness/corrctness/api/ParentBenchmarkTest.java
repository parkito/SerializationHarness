package ru.siksmfp.serialization.harness.corrctness.api;

import org.junit.jupiter.api.BeforeEach;
import ru.siksmfp.serialization.harness.banchmark.api.ParentBenchmark;
import ru.siksmfp.serialization.harness.state.api.BenchmarkState;

public abstract class ParentBenchmarkTest<S extends BenchmarkState, B extends ParentBenchmark> {

    protected S benchmarkState;
    protected B benchmark;

    public ParentBenchmarkTest(S benchmarkState, B benchmark) {
        this.benchmarkState = benchmarkState;
        this.benchmark = benchmark;
    }

    @BeforeEach
    void setUp() {
        benchmarkState.setUp();
    }

    public abstract void serializationCorrectness();

    public abstract void deSerializationCorrectness();
}
