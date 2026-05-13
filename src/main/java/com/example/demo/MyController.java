package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    @ResponseBody
    @GetMapping("/introduce")
    public String introduce(@RequestParam String name) {
        return "안녕하세요 제 이름은 " + name + "입니다!";
    }
}
