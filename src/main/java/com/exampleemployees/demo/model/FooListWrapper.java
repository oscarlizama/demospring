package com.exampleemployees.demo.model;

import java.util.List;

public class FooListWrapper {
    private List<Foo> fooList;

    public List<Foo> getFooList() {
        return fooList;
    }

    public void setFooList(List<Foo> fooList) {
        this.fooList = fooList;
    }

    public void add(Foo foo){
        this.fooList.add(foo);
    }

    @Override
    public String toString() {
        return "La lista contiene " + String.valueOf(fooList.size()) + " elementos";
    }
}
