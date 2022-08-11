package com.kodigoApplaudo.group2.bankingSpring.Controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    @Operation(summary = "View of login page")
    public String home() {
        return "login";
    }


}