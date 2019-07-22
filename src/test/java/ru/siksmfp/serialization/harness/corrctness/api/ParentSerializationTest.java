package ru.siksmfp.serialization.harness.corrctness.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;
import ru.siksmfp.serialization.harness.state.api.InputState;
import ru.siksmfp.serialization.harness.state.api.OutputState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ParentSerializationTest<T> {

    private Serializer<T> serializer;
    private OutputState<T> outputState;
    private InputState<T> inputState;

    public ParentSerializationTest(Serializer<T> serializer, OutputState<T> outputState, InputState<T> inputState) {
        this.serializer = serializer;
        this.outputState = outputState;
        this.inputState = inputState;
    }

    @BeforeEach
    void setUp() {
        inputState.setUp();
        outputState.setUp();
    }

    @Test
    void serializationCorrectness() {
        byte[] actualResult = outputState.getOutputObject();
        byte[] expectedResult = serializer.serialize(inputState.getInputObject());

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void deSerializationCorrectness() {
        T dto = inputState.getInputObject();
        byte[] bytes = serializer.serialize(dto);
        T deserializedUser = serializer.deSerialize(bytes);

        assertEquals(dto, deserializedUser);
    }
}
