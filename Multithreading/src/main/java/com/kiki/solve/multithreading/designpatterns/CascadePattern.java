package com.kiki.solve.multithreading.designpatterns;

import java.util.function.Consumer;

public class CascadePattern {
    /* Cascade Method Pattern - Mostly found in mockito
    helps to call several methods in order of execution
     errors will be difficult to debug*/
    /* Also known as Train Wreck pattern. */

    public CascadePattern from() {
        System.out.println("from ");
        return this;
    }

    public CascadePattern to() {
        System.out.println("to ");
        return this;
    }

    public CascadePattern subject() {
        System.out.println("subject ");
        return this;
    }

    public CascadePattern content() {
        System.out.println("content ");
        return this;
    }

    /*Accepting a consumer - object is created at owner side
    and api user dont have to worry about object creation
    he can just pass the chain of responsibilities to be invoked

    */
    public static void send(Consumer<CascadePattern> cascadePatternConsumer) {
        CascadePattern mailer = new CascadePattern();
        cascadePatternConsumer.accept(mailer);
        System.out.println("sending ");
    }


    public static void main(String[] args) {
        //CascadePattern mailer = new CascadePattern();

        CascadePattern.send(cascadePattern -> cascadePattern.from()
                .to()
                .subject()
                .content());


    }

}
