package ru.siksmfp.serialization.harness.corrctness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.banchmark.impl.SbeBenchmark;
import ru.siksmfp.serialization.harness.state.impl.SbeUserState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SbeBenchmarkCorrectnessTest {

    private SbeUserState userState;
    private SbeBenchmark benchmark;

    @BeforeEach
    void setUp() {
        userState = new SbeUserState();
        userState.setUp();

        benchmark = new SbeBenchmark();
    }

    @Test
    void serializationCorrectness() {
        byte[] actualResult = benchmark.serializationBenchmark(userState);
        byte[] expectedResult = userState.serializedUser.byteArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void deSerializationCorrectness() {
        String actualResult = benchmark.deSerializationBenchmark(userState);
        String expectedResult = userState.user.toString();
        assertEquals(expectedResult, actualResult);
    }
}
