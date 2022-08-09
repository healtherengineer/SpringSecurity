package com.egebarisan.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/index")
    public String index(){
        return "Index sayfasına hoşgeldiniz";
    }



    @GetMapping("/dashboard")
    public String dashboard(){
        return "Log in oldunuz Dashboard a hoşgeldiniz .";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Log in oldunuz ADMIN sayfasına hoşgeldiniz .";
    }
}
