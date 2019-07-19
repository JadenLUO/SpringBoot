package com.acxiom.springboot.boot001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class HelloController {

    @Value("${com.acxiom.title1}")
    String title1;
    @Value("${com.acxiom.title2}")
    String titile2;

    @RequestMapping("/hello")
    public String Hello(){

        return "Hello World!";
    }

    @RequestMapping("/title")
    public String getTitle(){

        return title1 + titile2;
    }
}
