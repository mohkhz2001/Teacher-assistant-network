package com.mohkhz.tanetwork.Controller;

import com.mohkhz.tanetwork.Impl.FileImplementation;
import com.mohkhz.tanetwork.Impl.UserImplementation;
import com.mohkhz.tanetwork.Model.Entity.File;
import com.mohkhz.tanetwork.Model.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 22 October 2022 at 12:26 PM
 */
@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    UserImplementation userImplementation;
    @Autowired
    FileImplementation fileImplementation;

    @GetMapping("/user")
    String showPageUser() {
        return "user_list";
    }

    @ModelAttribute("users")
    List<User> setUserList() {
        return userImplementation.getAll();
    }

    @ModelAttribute("username")
    String setUsername(Principal principal) {
        System.out.println(principal.getName());
        User user = userImplementation.findByStudentId(principal.getName());
        return user.getFullName();
    }

    @ModelAttribute("fileList")
    List<File> setFileList() {
        List<File> files = fileImplementation.getAll();
        return files;
    }

    @GetMapping("/file")
    String showPageFile(Model model) {
        return "file_list";
    }


}
