package com.kiki.solve.multithreading.effectiveJava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {
    // creaating defensivve copies by new date in constructor and new in getter
    private final Date date;

    private final List<String> items;

    // always take defensive copies and then check if time is before or after
    // so any change will not affect our object
    private Order(Date date, List<String> items) {
        this.date = new Date(date.getTime());
        this.items = items;
    }


    public static Order of(Date date,List<String> items) {
        Objects.requireNonNull(date);
        return new Order(date, new ArrayList<>(items));
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public List<String> getItems() {
        //can modify items on your returning list
        //return new ArrayList<>(items);
        return ImmutableList.copyOf(items);
        // will throw unsupported operation exception if add or remove elements.
    }
}
