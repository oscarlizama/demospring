package com.exampleemployees.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//Si no se especifica el nombre de la tabla por defecto coloca el nombre de la clase
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;
    //Si no se especifica el nombre del campo por defecto toma el nombre de la variable

    @Pattern(regexp = "^(?=.{3,50}$)[A-ZÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?$", message = "El primer nombre contiene caractéres inválidos o está escrito incorrectamente.")
    @Column(name ="firstName")
    private String firstName;

    @Pattern(regexp = "^$|(?=.{3,50}$)[A-ZÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?$", message = "El segundo nombre contiene caractéres inválidos o está escrito incorrectamente.")
    @Column(name ="secondName")
    private String secondName;

    @Pattern(regexp = "^(?=.{3,50}$)[A-ZÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?$", message = "El apellido contiene caractéres inválidos o está escrito incorrectamente.")
    @Column(name = "lastName")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "El correo ingresado no es válido.")
    @Column(name = "email")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name="fechaNacimiento", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Por favor ingrese la fecha de nacimiento")
    private Date fechaNacimiento;

    @Valid
    @OneToMany(mappedBy = "employee")
    private List<Foo> fooList;

    public Employee() {
        super();
        fooList = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Foo> getFooList() {
        return fooList;
    }

    public void setFooList(List<Foo> fooList) {
        this.fooList = fooList;
    }
}
