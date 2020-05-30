package com.kiki.solve.multithreading.designpatterns.creational.abstractfactory;

public class ComputerFactoryA implements ComputerFactory {
    @Override
    public Cpu getCpu() {
        return new CPUA();
    }

    @Override
    public Memory getMemory() {
        return new MemoryA();
    }
}
