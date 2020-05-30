package com.kiki.solve.multithreading.effectiveJava;

import jdk.nashorn.internal.ir.FunctionCall;

import java.time.Instant;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferences {

    public static void main(String[] args) {
        st(Integer::parseInt);
        bound(Instant.now()::isAfter);
        unbound(String::toLowerCase);
        constructor(TreeMap::new);
        //array(integer -> new int[integer]); -- traditional lamda approach
        array(int[]::new);
    }

    public  static void st(Function<String,Integer> function){

    }

    public static void bound(Predicate<Instant> predicate){

    }

    public static void unbound(UnaryOperator<String> operator){

    }
    public static void constructor(Supplier<TreeMap<String,String>>  supplier){

    }

    // recieves input as Integer and returns int array
    public static void array(Function<Integer,int[]> function){

    }


}
