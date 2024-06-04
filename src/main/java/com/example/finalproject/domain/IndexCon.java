package com.example.finalproject.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexCon {

    @GetMapping("/health")
    public String healthCheck(){
        return "OK";
    }
}
