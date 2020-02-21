package main.controller;

import main.model.api.Init;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/api/init/")
    public Init getInfo(){
        return new Init();
    }



}
