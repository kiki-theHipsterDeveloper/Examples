package com.kiki.solve.multithreading.effectiveJava;

import java.io.Serializable;
import java.util.Optional;

public class Customer implements Serializable {
    /**
     * returns null;
     */
    private String title;


    // wrong approach to use in fields
    //cannot automatically bind properties to fields as done by some frameworks
    //private Optional<String> title;

    //Optional is not serializable we need to use speicific read and write methods to serilize it.

    //Always use optional for return types of methods
    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }
}
