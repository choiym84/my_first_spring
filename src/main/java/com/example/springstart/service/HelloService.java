package com.example.springstart.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello(String name) {
        if (name == null || name.isBlank()) {
            name = "guest";
        }
        return "안녕하세요  " + name + "님! 환영합니다. ";
    }
}
