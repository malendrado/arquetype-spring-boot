package com.cortesdev.controller;

import com.cortesdev.interfaces.ITestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/")
@Api(value="TestController")
public class TestController {
    
    @Autowired
    private ITestService iTestService;

    @GetMapping("/test")
    public Object getTest(){
        return iTestService.getTest();
    }

}
