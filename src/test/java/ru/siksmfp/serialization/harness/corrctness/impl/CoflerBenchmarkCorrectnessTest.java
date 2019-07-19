package ru.siksmfp.serialization.harness.corrctness.impl;

import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.banchmark.impl.CoflerBenchmark;
import ru.siksmfp.serialization.harness.corrctness.api.ParentBenchmarkTest;
import ru.siksmfp.serialization.harness.model.cofler.User;
import ru.siksmfp.serialization.harness.state.impl.CoflerUserState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoflerBenchmarkCorrectnessTest extends ParentBenchmarkTest<CoflerUserState, CoflerBenchmark> {

    public CoflerBenchmarkCorrectnessTest() {
        super(new CoflerUserState(), new CoflerBenchmark());
    }

    @Test
    @Override
    public void serializationCorrectness() {
        byte[] actualResult = benchmark.serializationBenchmark(benchmarkState);
        byte[] expectedResult = benchmarkState.getOutputObject().array();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    @Override
    public void deSerializationCorrectness() {
        User actualResult = benchmark.deSerializationBenchmark(benchmarkState);
        User expectedResult = benchmarkState.getInputObject();

        assertEquals(expectedResult, actualResult);
    }
}
