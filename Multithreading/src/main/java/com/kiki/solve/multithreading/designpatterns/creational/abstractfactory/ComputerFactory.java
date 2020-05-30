package com.kiki.solve.multithreading.designpatterns.creational.abstractfactory;

public interface ComputerFactory {
    Cpu getCpu();
    Memory getMemory();
}
