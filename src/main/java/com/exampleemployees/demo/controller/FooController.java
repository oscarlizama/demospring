package com.exampleemployees.demo.controller;

import com.exampleemployees.demo.model.Foo;
import com.exampleemployees.demo.model.FooListWrapper;
import com.exampleemployees.demo.service.FooServiceImpl;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FooController {

    @Autowired
    private FooServiceImpl fooService;

    @GetMapping("/fooi")
    public String viewHomeFoo(Model model){
        FooListWrapper fooListWrapper = new FooListWrapper();
        model.addAttribute("fooListWrapper", fooListWrapper);
        return "foo_form";
    }

    //@RequestMapping(value = "/fooWrapper", method = RequestMethod.POST)
    @PostMapping("/fooWrapper")
    public String addFoo(@ModelAttribute("fooListWrapper") FooListWrapper fooListWrapper){
        for (Foo foo : fooListWrapper.getFooList()) {
            if (!foo.getName().equals(""))
                fooService.saveFoo(foo);
            System.out.println("Valor del foo: " + foo.getName());
        }
        System.out.println(fooListWrapper.toString());
        return "foo_form";
    }

}
