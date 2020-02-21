package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiGeneralController {

    @GetMapping("api/init")
    String getInit(){
        return null;
    }

}
