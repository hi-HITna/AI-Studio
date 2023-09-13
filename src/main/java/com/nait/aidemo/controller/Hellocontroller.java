package com.nait.aidemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class Hellocontroller {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String Hello(){
        return "hello world!你好呀千千";
    }
}
