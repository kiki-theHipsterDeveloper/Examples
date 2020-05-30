package com.kiki.solve.multithreading.designpatterns.creational.abstractfactory;

public abstract class Memory {

    @Override
    public String toString() {
        return String.format("%s %d",getClass(),hashCode());
    }
}
