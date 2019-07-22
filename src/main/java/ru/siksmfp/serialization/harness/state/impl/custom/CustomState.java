package ru.siksmfp.serialization.harness.state.impl.custom;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import ru.siksmfp.serialization.harness.model.custom.CustomModel;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;
import ru.siksmfp.serialization.harness.serializer.impl.custom.CustomSerializer;
import ru.siksmfp.serialization.harness.state.api.InputState;
import ru.siksmfp.serialization.harness.state.api.OutputState;

@State(Scope.Benchmark)
public class CustomState implements OutputState<CustomModel>, InputState<CustomModel> {

    private Serializer<CustomModel> serializer;
    private byte[] serializedModel;
    private CustomModel customDto;

    @Override
    public CustomModel getInputObject() {
        return customDto;
    }

    @Override
    public Serializer<CustomModel> getSerializer() {
        return serializer;
    }

    @Override
    public byte[] getOutputObject() {
        return serializedModel;
    }

    @Override
    @Setup(Level.Trial)
    public void setUp() {
        customDto = new CustomModel();
        //populate model with default values here

        serializer = new CustomSerializer();
        serializedModel = serializer.serialize(customDto);
    }
}