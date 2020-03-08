package main.controller;

import main.model.api.Init;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute(new Init());
        return "index";
    }





}
