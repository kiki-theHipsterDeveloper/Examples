package com.kiki.solve.multithreading.designpatterns.creational.abstractfactory;
// Families of abstract - Computer, Cpu, Memory

public abstract class Computer {

    private Cpu _cpu;
    private  Memory _memory;

    @Override
    public String toString() {
        return String.format("%s %s %s ",getClass(),_cpu,_memory);
    }

    public void add(Cpu cpua) {
        _cpu = cpua;
    }

    public void add(Memory memoryA) {
        _memory = memoryA;
    }

    public abstract String getPartsType();
}
