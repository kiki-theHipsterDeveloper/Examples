package com.kiki.solve.multithreading.effectiveJava;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Streams {
    /**
     * 1. Unary operaator -> an operator which returns itself
     * 2.Binary Operator -> an operator takes two inputs of same
     * 3.Predicate
     * 4.Function
     * 4.Supplier
     * 5.Consumer
     */

    public static final String[] strings = { "a","7","b","4","z","T","200","h","2"};

    public static void main(String[] args) {
        //Unaryoperator - usually used to create infinite stream
        //before lambdas
        Stream.iterate(0, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        });

        //after lambdas

        Stream.iterate(0,integer -> integer + 2);

        //binary operator - mostly used for reduce operation

        Integer integer = Stream.of(1, 2, 3, 4).reduce((x, y) -> x + y).orElse(20);
        System.out.println(integer);

        //Predicate & Function
        // we are taking numbers from string array and converting to integers
        Stream.of(strings)
                .filter(s -> s.matches("\\d+")) // filter always takes predicate and return stream
                .map(s -> Integer.parseInt(s)) // map always takes a function an return stream
                .forEach(System.out::println);

        //Supplier

        Optional<Integer> reduce = Stream.of(1, 2, 3, 4).reduce((integer1, integer2) -> integer1 + integer2);
        // Here else method computes and keeps value if optional value is present also
        reduce.orElse(5 * 5);
        // Here Supplier argument to OrElseGEt is executed only if optional value is not present.
        // () Supplier recieves nothing --> no Argument
        reduce.orElseGet(() -> 5*5 );

        reduce.orElseThrow(() -> new IllegalStateException("blabla"));


        //Function Identity - to return same item recieved as input

        Stream.of(strings)
                // .map(s -> s)
                .map(Function.identity())
                .filter(s -> s.matches("\\d+")) // filter always takes predicate and return stream
                .map(s -> Integer.parseInt(s)) // map always takes a function an return stream
                .forEach(System.out::println);

        

    }
}
