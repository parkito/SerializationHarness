package ru.siksmfp.serialization.harness.serializer.impl.custom;

import ru.siksmfp.serialization.harness.converter.impl.custom.CustomConverter;
import ru.siksmfp.serialization.harness.dto.custom.CustomDto;
import ru.siksmfp.serialization.harness.model.custom.CustomModel;
import ru.siksmfp.serialization.harness.serializer.api.Serializer;

public class CustomSerializer implements Serializer<CustomModel> {

    private CustomConverter converter = new CustomConverter();

    @Override
    public byte[] serialize(CustomModel dto) {
        CustomDto customDto = converter.toDto(dto);
        //implement serialization of dto to byte array

        return new byte[0];
    }

    @Override
    public CustomModel deSerialize(byte[] bytes) {
        CustomDto dto = new CustomDto("1");
        //implement deserialization of byte array into dto

        return converter.toModel(dto);
    }
}
