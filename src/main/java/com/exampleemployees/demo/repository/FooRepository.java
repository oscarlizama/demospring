package com.exampleemployees.demo.repository;

import com.exampleemployees.demo.model.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooRepository extends JpaRepository<Foo, Long> {

}
