package com.example.basicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private")
public class PrivateController {

    @GetMapping()
    public String helloWorld(){

        return "Hello World from private Controller.";
    }
    @GetMapping("/user")
    public String helloUserWorld(){
        return "Hello World from user public Controller.";
    }
    //    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String helloAdminWorld(){
        return "Hello World from admin public Controller.";
    }
}
