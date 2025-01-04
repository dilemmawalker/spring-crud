package com.dilemmawalker.demo.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
