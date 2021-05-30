package com.exampleemployees.demo.model;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "foo")
public class Foo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Foo inválido")
    @Column(name ="name")
    private String name;

    @JoinColumn(name = "employee_id")
    @ManyToOne(optional = false)
    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
