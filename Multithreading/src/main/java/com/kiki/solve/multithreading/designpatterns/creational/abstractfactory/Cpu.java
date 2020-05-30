package com.kiki.solve.multithreading.designpatterns.creational.abstractfactory;

public abstract class Cpu {

    @Override
    public String toString() {
        return String.format("%s %d",getClass(),hashCode());
    }
}
