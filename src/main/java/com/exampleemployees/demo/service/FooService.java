package com.exampleemployees.demo.service;

import com.exampleemployees.demo.model.Foo;

public interface FooService {
    void saveFoo(Foo foo);
    void deleteFoo(long id);
}
