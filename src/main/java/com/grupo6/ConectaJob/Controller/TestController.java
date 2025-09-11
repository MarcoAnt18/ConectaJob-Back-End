package com.grupo6.ConectaJob.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TEST")
public class TestController {
    @GetMapping
    public String helloword (){
        return "hello-word";
    }

    @GetMapping("/tokenTest")
    public String tokenOK (){
        return "token OK";
    }

}
