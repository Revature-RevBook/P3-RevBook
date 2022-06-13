package org.revature.revbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class hello {
    
    @GetMapping(path = "")
    public String hello() {
        return "Hello";
    }
}
