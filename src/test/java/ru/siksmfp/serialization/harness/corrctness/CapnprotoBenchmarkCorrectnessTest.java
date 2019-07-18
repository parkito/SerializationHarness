package ru.siksmfp.serialization.harness.corrctness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.banchmark.impl.CapnprotoBenchmark;
import ru.siksmfp.serialization.harness.model.capnp.UserModel;
import ru.siksmfp.serialization.harness.state.impl.CapnprotoUserState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapnprotoBenchmarkCorrectnessTest {

    private CapnprotoUserState userState;
    private CapnprotoBenchmark benchmark;

    @BeforeEach
    void setUp() {
        userState = new CapnprotoUserState();
        userState.setUp();

        benchmark = new CapnprotoBenchmark();
    }

    @Test
    void serializationCorrectness() {
        byte[] actualResult = benchmark.serializationBenchmark(userState);
        byte[] expectedResult = userState.getOutputObject().array();

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void deSerializationCorrectness() {
        UserModel.User.Reader actualResult = benchmark.deSerializationBenchmark(userState);
        UserModel.User.Reader expectedResult = userState.getInputObject().getRoot(UserModel.User.factory).asReader();

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
