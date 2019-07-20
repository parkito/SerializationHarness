package ru.siksmfp.serialization.harness.corrctness.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.siksmfp.serialization.harness.model.standart.User;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;
import ru.siksmfp.serialization.harness.state.api.OutputState;
import ru.siksmfp.serialization.harness.state.impl.InputUserState;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ParentSerializationTest {

    private Serializer<User> serializer;
    private OutputState outputState;
    private InputUserState inputUserState;

    public ParentSerializationTest(Serializer<User> serializer, OutputState outputState) {
        this.serializer = serializer;
        this.outputState = outputState;
        inputUserState = new InputUserState();
    }

    @BeforeEach
    void setUp() {
        inputUserState.setUp();
        outputState.setUp();
    }

    @Test
    public void serializationCorrectness() {
        byte[] actualResult = outputState.getOutputObject();
        byte[] expectedResult = serializer.serialize(inputUserState.getInputObject());

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void deSerializationCorrectness() {
        User dto = inputUserState.getInputObject();
        byte[] bytes = serializer.serialize(dto);
        User deserializedUser = serializer.deSerialize(bytes);

        assertEquals(dto, deserializedUser);
    }
}
