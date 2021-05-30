package com.exampleemployees.demo.controller;

import com.exampleemployees.demo.model.Employee;
import com.exampleemployees.demo.model.Foo;
import com.exampleemployees.demo.service.EmployeeService;
import com.exampleemployees.demo.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FooService fooService;

    //Display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model){

        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/newEmployee")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult br, Model model){
        if (br.hasErrors()){
            model.addAttribute("employee", employee);
            System.out.println("Cantidad de errores: " + String.valueOf(br.getErrorCount()));
            for (ObjectError error : br.getAllErrors()) {
                System.out.println("Error: " + error.toString());
            }
            return "new_employee";
        }
        //Save employee to DB
        employeeService.saveEmployee(employee);
        for (Foo fooElement : employee.getFooList()) {
            fooElement.setEmployee(employee);
            fooService.saveFoo(fooElement);
            System.out.println("Foo element: " + fooElement.getName());
        }
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id){
        //Delete employee
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping("/employee/foo/delete/{employee}/{id}")
    public String deleteFooEmployee(
            @PathVariable (value = "employee") long employee,
            @PathVariable(value = "id") long id,
            Model model){
        this.fooService.deleteFoo(id);
        return showFormForUpdate(employee, model);
    }

}
