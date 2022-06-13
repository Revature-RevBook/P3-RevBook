package org.revature.revbook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "")
public class hello {
    
    @GetMapping(path = "")
    public String hello() {
        return "Hello";
    }
}
