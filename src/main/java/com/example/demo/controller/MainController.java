package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping
    public String main() {
        return "DemoApplication<br>" +
                "<a href=\"http://localhost:8080/cars\">Get all cars</a><br>" +
                "<a href=\"http://localhost:8080/cars/create-default\">Create default car</a><br>" +
                "<a href=\"http://localhost:8080/cars/ids\">Get all cars id</a><br>" +
                "<a href=\"http://localhost:8080/cars/model?model=\">Find by model</a><br>" +
                "<a href=\"http://localhost:8080/cars/show/\">Find by id</a><br>";
    }
}
