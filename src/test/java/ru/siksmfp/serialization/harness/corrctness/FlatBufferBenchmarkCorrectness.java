package ru.siksmfp.serialization.harness.corrctness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.banchmark.impl.FlatBufferBenchmark;
import ru.siksmfp.serialization.harness.model.proto.UserProto;
import ru.siksmfp.serialization.harness.state.impl.FlatBufferUserState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlatBufferBenchmarkCorrectness {

    private FlatBufferUserState userState;
    private FlatBufferBenchmark benchmark;

    @BeforeEach
    void setUp() {
        userState = new FlatBufferUserState();
        userState.setUp();

        benchmark = new FlatBufferBenchmark();
    }

    @Test
    void serializationCorrectness() {
        byte[] actualResult = benchmark.serializationBenchmark(userState);
        byte[] expectedResult = userState.serializedUser;
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void deSerializationCorrectness() {
        UserProto.User actualResult = benchmark.deSerializationBenchmark(userState);
        UserProto.User expectedResult = userState.userProto;
        assertEquals(expectedResult, actualResult);
    }
}
