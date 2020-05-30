package com.kiki.solve.multithreading.effectiveJava;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static com.google.common.base.Preconditions.checkState;

public class Person {
    private final String name;
    private final String surname;
    private String prefix;
    private String title;

    private Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.prefix = personBuilder.prefix;
        this.title = personBuilder.title;
    }

    public static class PersonBuilder {
        private final String name;
        private final String surname;
        private String prefix;
        private String title;

        private PersonBuilder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public static PersonBuilder createPersonBuilder(String name, String surname) {
            return new PersonBuilder(name, surname);
        }

        public PersonBuilder setPrefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public PersonBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Person build() {
            checkState(title !=null && prefix !=null);
            return new Person(this);
        }


    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static void main(String[] args) {
   /*     Person person = PersonBuilder.createPersonBuilder("Alan", "Lane").setPrefix("Mr")
                .build();
        System.out.println(person);*/

      /*  Exception in thread "main" java.lang.IllegalStateException
        at com.google.common.base.Preconditions.checkState(Preconditions.java:492)
        at com.kiki.solve.multithreading.effectiveJava.Person$PersonBuilder.build(Person.java:44)
        at com.kiki.solve.multithreading.effectiveJava.Person.main(Person.java:53)*/

        Person person2 = PersonBuilder.createPersonBuilder("Alan", "Lane").setPrefix("Mr")
                .setTitle("Program Manager")
                .build();
        System.out.println(person2);
    }
}
