package org.pract.demo.two.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
public class AdminController {
    @RequestMapping("/hello")
    public String helloAdmin() {
        return "hello admin";
    }
}
