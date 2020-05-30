package com.kiki.solve.multithreading.designpatterns.creational.abstractfactory;

public class sample {

    //Open Closed Principle
    //Liskov Substituation principle

    //provide interface for creating related or dependent objects without specifying
    //their concrete classes

    // abstracts the instantiation of classes

    // Supporting new kinds (not Type) of products is difficult. Eg Computer with Additional peripheral.



    public static void main(String[] args) {
        ComputerA computer1 = new ComputerA();

        createComputer(computer1);

        System.out.println(computer1);


        //Clearly violating DRY principle
        ComputerB computer2 = new ComputerB();

        createComputer(computer2);

        System.out.println(computer2);

        //Avoiding violating DRY by abstracting Memory and CPU class

        Memory memory = new MemoryA();
        Cpu cpu = new CPUA();
        //abstracting computer also


    }

   /* private static void createComputer(ComputerA computer) {
        computer.add(new CPUA());
        computer.add(new MemoryA());
    }
    // Violating DRY principle
    private static void createComputer(ComputerB computer) {
        computer.add(new CPUB());
        computer.add(new MemoryB());
    }*/


    //violates Open Closed principle - Open for Extension but Closed for modification of code
    // here we need to modify if loop if ComputerC is added.
    //Solution is abstract factory
   /* private static void createComputer(Computer computer) {
        if (computer instanceof ComputerA) {
            computer.add(new CPUA());
            computer.add(new MemoryA());
        }else {
            computer.add(new CPUB());
            computer.add(new MemoryB());
        }
    }*/



  /*  private static void createComputer(Computer computer,ComputerFactory computerFactory) {

            computer.add(computerFactory.getCpu());
            computer.add(computerFactory.getMemory());

    }*/

    // Still we are creating factories A and B.

    /**
     * using reflection to solve this. Class.forName
     */

    private static void createComputer(Computer computer) {
        String partsType = computer.getPartsType();
        try {
            computer.add((Cpu) Class.forName("com.kiki.solve.multithreading.designpatterns.creational.abstractfactory.CPU" + partsType).newInstance());
            computer.add((Memory) Class.forName("com.kiki.solve.multithreading.designpatterns.creational.abstractfactory.Memory" + partsType).newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
