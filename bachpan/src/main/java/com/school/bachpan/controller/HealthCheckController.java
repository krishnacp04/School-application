package com.school.bachpan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(value = "/healthCheck")
    public String getBachpanHealthCheck(){
        return "Bachpan School Application up and running";
    }
}
