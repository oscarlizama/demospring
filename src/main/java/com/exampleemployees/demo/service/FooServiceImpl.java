package com.exampleemployees.demo.service;

import com.exampleemployees.demo.model.Foo;
import com.exampleemployees.demo.repository.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService{

    @Autowired
    private FooRepository fooRepository;

    @Override
    public void saveFoo(Foo foo) {
        this.fooRepository.save(foo);
    }

    @Override
    public void deleteFoo(long id) {
        this.fooRepository.deleteById(id);
    }
}
