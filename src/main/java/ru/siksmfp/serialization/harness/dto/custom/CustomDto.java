package ru.siksmfp.serialization.harness.dto.custom;

import java.util.Objects;

public class CustomDto {
    private String id;

    public CustomDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomDto customDto = (CustomDto) o;
        return id.equals(customDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
