package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

/**
 * Created by hx on 2017/11/4.
 */
@RestController
public class DemoController {

    @Autowired
    private com.example.properties.GradeProperties GradeProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name",required = false,defaultValue = "summer") String name){
        return "name:" + name;
        //return GradeProperties.getScore();

    }
}
