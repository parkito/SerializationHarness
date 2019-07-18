package ru.siksmfp.serialization.harness.corrctness.impl;

import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.banchmark.impl.FlatBufferBenchmark;
import ru.siksmfp.serialization.harness.corrctness.api.ParentBenchmarkTest;
import ru.siksmfp.serialization.harness.model.proto.UserProto;
import ru.siksmfp.serialization.harness.state.impl.FlatBufferUserState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlatBufferBenchmarkCorrectness extends ParentBenchmarkTest<FlatBufferUserState, FlatBufferBenchmark> {

    FlatBufferBenchmarkCorrectness() {
        super(new FlatBufferUserState(), new FlatBufferBenchmark());
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
        UserProto.User actualResult = benchmark.deSerializationBenchmark(benchmarkState);
        UserProto.User expectedResult = benchmarkState.getInputObject();

        assertEquals(expectedResult, actualResult);
    }
}
