package com.kiki.solve.multithreading.effectiveJava;

import javax.persistence.*;

@Converter(autoApply = true)
public class Java8EnumOperationsAttributeConverter implements AttributeConverter<Java8EnumOperations,String>{


    public String convertToDatabaseColumn(Java8EnumOperations java8EnumOperations) {
        return java8EnumOperations.toDatabaseValue();
    }

    public Java8EnumOperations convertToEntityAttribute(String s) {
        return Java8EnumOperations.fromString(s).orElse(Java8EnumOperations.ADD);
    }
}
