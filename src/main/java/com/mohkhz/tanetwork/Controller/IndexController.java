package com.mohkhz.tanetwork.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 22 October 2022 at 11:20 PM
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    String index(){
        return "redirect:/list/file";
    }
}
