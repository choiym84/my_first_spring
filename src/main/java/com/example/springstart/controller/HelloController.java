package com.example.springstart.controller;

import com.example.springstart.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello spring";
    }

    @GetMapping("/hello-view")
    public String helloView() {
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(required = false) String name, Model model) {
        String welcome = helloService.sayHello(name);
        model.addAttribute("welcome", welcome);
        return "service";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }
}
