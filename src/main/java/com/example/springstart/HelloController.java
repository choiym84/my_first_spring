package com.example.springstart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

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

        if (name == null || name.isBlank()) {
            name = "guest";
        }
        model.addAttribute("name", name);
        return "hello-mvc";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }
}
