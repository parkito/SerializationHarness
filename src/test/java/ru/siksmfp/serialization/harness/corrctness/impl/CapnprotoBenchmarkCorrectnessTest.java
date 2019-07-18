package ru.siksmfp.serialization.harness.corrctness.impl;

import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.banchmark.impl.CapnprotoBenchmark;
import ru.siksmfp.serialization.harness.corrctness.api.ParentBenchmarkTest;
import ru.siksmfp.serialization.harness.model.capnp.UserModel;
import ru.siksmfp.serialization.harness.state.impl.CapnprotoUserState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapnprotoBenchmarkCorrectnessTest extends ParentBenchmarkTest<CapnprotoUserState, CapnprotoBenchmark> {

    CapnprotoBenchmarkCorrectnessTest() {
        super(new CapnprotoUserState(), new CapnprotoBenchmark());
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
        UserModel.User.Reader actualResult = benchmark.deSerializationBenchmark(benchmarkState);
        UserModel.User.Reader expectedResult = benchmarkState.getInputObject().getRoot(UserModel.User.factory).asReader();

        assertEquals(expectedResult.getId(), actualResult.getId());
        assertEquals(expectedResult.getName().toString(), actualResult.getName().toString());
        assertArrayEquals(expectedResult.getSignature().toArray(), actualResult.getSignature().toArray());

        for (int i = 0; i < 5; i++) {
            assertEquals(expectedResult.getAddresses().get(i).getId(), actualResult.getAddresses().get(i).getId());
            assertEquals(expectedResult.getAddresses().get(i).getCity().toString(), actualResult.getAddresses().get(i).getCity().toString());
            assertEquals(expectedResult.getAddresses().get(i).getPopulation(), actualResult.getAddresses().get(i).getPopulation());
        }
    }
}
