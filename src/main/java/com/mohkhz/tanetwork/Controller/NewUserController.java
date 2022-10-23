package com.mohkhz.tanetwork.Controller;

import com.mohkhz.tanetwork.Impl.UserImplementation;
import com.mohkhz.tanetwork.Model.Entity.User;
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
 * @create 21 October 2022 at 9:39 PM
 */
@Controller
@RequestMapping("/new/user")
public class NewUserController {

    @Autowired
    UserImplementation userImplementation;

    @ModelAttribute("user")
    User setUser() {
        return new User();
    }

    @GetMapping
    String showPage() {
        return "new_user";
    }

    @PostMapping
    String newUser(User user) {
        User user1 = userImplementation.newUserAdmin(user);
        if (user1 != null) {
            return "redirect:/manage/user";
        }
        return "redirect:/manage/user";
    }

}
