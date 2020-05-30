package com.kiki.solve.multithreading.designpatterns.creational.abstractfactory;

public class ComputerFactoryB implements ComputerFactory {
    @Override
    public Cpu getCpu() {
        return new CPUB();
    }

    @Override
    public Memory getMemory() {
        return new MemoryB();
    }
}
