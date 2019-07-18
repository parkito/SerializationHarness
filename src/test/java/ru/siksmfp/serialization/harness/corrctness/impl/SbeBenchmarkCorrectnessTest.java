package ru.siksmfp.serialization.harness.corrctness.impl;

import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.banchmark.impl.SbeBenchmark;
import ru.siksmfp.serialization.harness.corrctness.api.ParentBenchmarkTest;
import ru.siksmfp.serialization.harness.state.impl.SbeUserState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SbeBenchmarkCorrectnessTest extends ParentBenchmarkTest<SbeUserState, SbeBenchmark> {

    SbeBenchmarkCorrectnessTest() {
        super(new SbeUserState(), new SbeBenchmark());
    }

    @Test
    @Override
    public void serializationCorrectness() {
        byte[] actualResult = benchmark.serializationBenchmark(benchmarkState);
        byte[] expectedResult = benchmarkState.getOutputObject().byteArray();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    @Override
    public void deSerializationCorrectness() {
        String actualResult = benchmark.deSerializationBenchmark(benchmarkState);
        String expectedResult = benchmarkState.getInputObject().toString();

        assertEquals(expectedResult, actualResult);
    }
}
