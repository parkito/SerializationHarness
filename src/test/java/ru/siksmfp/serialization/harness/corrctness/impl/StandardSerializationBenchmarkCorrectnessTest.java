package ru.siksmfp.serialization.harness.corrctness.impl;

import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.banchmark.impl.StandardSerializationBenchmark;
import ru.siksmfp.serialization.harness.corrctness.api.ParentBenchmarkTest;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.state.impl.StandardUserState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardSerializationBenchmarkCorrectnessTest extends ParentBenchmarkTest<StandardUserState, StandardSerializationBenchmark> {

    public StandardSerializationBenchmarkCorrectnessTest() {
        super(new StandardUserState(), new StandardSerializationBenchmark());
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
