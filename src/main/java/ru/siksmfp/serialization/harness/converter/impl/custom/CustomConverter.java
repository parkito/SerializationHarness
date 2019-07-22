package ru.siksmfp.serialization.harness.converter.impl.custom;

import ru.siksmfp.serialization.harness.converter.api.Converter;
import ru.siksmfp.serialization.harness.dto.custom.CustomDto;
import ru.siksmfp.serialization.harness.model.custom.CustomModel;

public class CustomConverter implements Converter<CustomModel, CustomDto> {

    @Override
    public CustomModel toModel(CustomDto dto) {
        return new CustomModel(1);
    }

    @Override
    public CustomDto toDto(CustomModel model) {
        return new CustomDto("1");
    }
}
