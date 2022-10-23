package com.mohkhz.tanetwork.Controller;

import com.mohkhz.tanetwork.Impl.UserImplementation;
import com.mohkhz.tanetwork.Model.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:32 AM
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserImplementation userImplementation;

    @GetMapping
    String showPage(Principal principal) {
        if (principal != null) {
            return "redirect:/list/file";
        }
        return "login";
    }


}
