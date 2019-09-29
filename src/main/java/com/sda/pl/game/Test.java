package com.sda.pl.game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
    @GetMapping("/hello-world")
    public String getHelloWorld() {
        return "catsView";
    }

}
