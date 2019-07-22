package ru.siksmfp.serialization.harness.state.impl.custom;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import ru.siksmfp.serialization.harness.dto.custom.CustomDto;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;
import ru.siksmfp.serialization.harness.serializer.impl.custom.CustomSerializer;
import ru.siksmfp.serialization.harness.state.api.InputState;
import ru.siksmfp.serialization.harness.state.api.OutputState;

public class CustomState implements OutputState<CustomDto>, InputState<CustomDto> {

    private Serializer<CustomDto> serializer;
    private byte[] serializedModel;
    private CustomDto customDto;

    @Override
    public CustomDto getInputObject() {
        return customDto;
    }

    @Override
    public Serializer<CustomDto> getSerializer() {
        return serializer;
    }

    @Override
    public byte[] getOutputObject() {
        return serializedModel;
    }

    @Override
    @Setup(Level.Trial)
    public void setUp() {
        customDto = new CustomDto();
        //populate dto with default values here

        serializer = new CustomSerializer();
        serializedModel = serializer.serialize(customDto);
    }
}