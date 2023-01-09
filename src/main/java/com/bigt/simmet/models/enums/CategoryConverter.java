package com.bigt.simmet.models.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Condition, String> {

    @Override
    public String convertToDatabaseColumn(Condition attribute) {
        return attribute.getShortName();
    }

    @Override
    public Condition convertToEntityAttribute(String dbData) {
        return Condition.fromShortName(dbData);
    }
}
