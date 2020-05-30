package com.kiki.solve.multithreading.effectiveJava;

import java.util.Map;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Java8EnumOperations {

    ADD ((x, y) -> x + y, "A"),
    SUBTRACT(Subtract::sub, "B");

    private final IntBinaryOperator intBinaryOperator;

    private final String databaseValue;

    private static final Map<String,Java8EnumOperations> VALUE_MAP = Stream.of(values()).collect(Collectors.toMap(o -> o.databaseValue,o -> o));
    private Java8EnumOperations(IntBinaryOperator intBinaryOperator, String databaseValue) {
        this.intBinaryOperator = intBinaryOperator;
        this.databaseValue = databaseValue;
    }

    public String toDatabaseValue(){
        return databaseValue;
    }

    //Here optional is added to prevent client code from handling null
    //other way is to implement AttributeConverter to ensure non nullability of entities
    public static Optional<Java8EnumOperations> fromString(String databaseValue){
      //return  VALUE_MAP.getOrDefault(databaseValue,Java8EnumOperations.ADD)
    return Optional.ofNullable(VALUE_MAP.get(databaseValue));
    // do not return null always return empty.
        // return Optional.empty();

    //return Optional.of(Java8EnumOperations.ADD);

        //Optional is not serializable
    }


}
