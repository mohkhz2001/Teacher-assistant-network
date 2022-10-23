package com.mohkhz.tanetwork.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accessDenied")
public class AccessDeniedController {

    @GetMapping
    public String accessDenied() {
        return "accessDenied";
    }

}
