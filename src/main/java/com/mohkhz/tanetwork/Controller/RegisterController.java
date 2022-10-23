package com.mohkhz.tanetwork.Controller;

import com.mohkhz.tanetwork.Impl.UserImplementation;
import com.mohkhz.tanetwork.Model.Entity.User;
import com.mohkhz.tanetwork.Repository.UserRepository;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:32 AM
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserImplementation userImplementation;

    @ModelAttribute("user")
    public User setUser() {
        return new User();
    }

    @GetMapping
    String showPage() {
        return "register";
    }

    @PostMapping
    String newUser(User user) {
        System.out.println(user.getName());

        if (user == null) {
            System.out.println("wrong");
            return "redirect:/register";
        }
        System.out.println(user.getStudentId());

        userImplementation.newUser(user);

        return "redirect:/login?success";
    }

}
