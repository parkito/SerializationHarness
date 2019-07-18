package ru.siksmfp.serialization.harness.corrctness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.banchmark.impl.StandardSerializationBenchmark;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.state.impl.StandardUserState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardSerializationBenchmarkTest {

    private StandardUserState userState;
    private StandardSerializationBenchmark benchmark;

    @BeforeEach
    void setUp() {
        userState = new StandardUserState();
        userState.setUp();

        benchmark = new StandardSerializationBenchmark();
    }

    @Test
    void serializationCorrectness() {
        byte[] actualResult = benchmark.serializationBenchmark(userState);
        byte[] expectedResult = userState.getOutputObject().array();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void deSerializationCorrectness() {
        User actualResult = benchmark.deSerializationBenchmark(userState);
        User expectedResult = userState.getInputObject();
        assertEquals(expectedResult, actualResult);
    }
}
