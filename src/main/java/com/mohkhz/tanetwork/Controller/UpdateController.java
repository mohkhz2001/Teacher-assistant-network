package com.mohkhz.tanetwork.Controller;

import com.mohkhz.tanetwork.Impl.FileImplementation;
import com.mohkhz.tanetwork.Impl.UserImplementation;
import com.mohkhz.tanetwork.Model.Entity.File;
import com.mohkhz.tanetwork.Model.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 22 October 2022 at 12:03 PM
 */

@Controller
@RequestMapping("/update")
public class UpdateController {

    @Autowired
    FileImplementation fileImplementation;
    @Autowired
    UserImplementation userImplementation;

    @GetMapping("/file/{fid}")
    String updateFile(@PathVariable("fid") Long Fid, Model model) {
        File file = fileImplementation.getById(Fid);
        model.addAttribute("file", file);
        return "update_file";
    }

    @PostMapping("/file")
    String updateFile(File file, @RequestBody @ModelAttribute("file") File modelFile) {
        File file1 = fileImplementation.addNewFile(file);
        if (file1 != null && file1.getId().equals(file.getId()))
            return "redirect:/manage/file";
        return "redirect:/manage/file";
    }

    @GetMapping("/user/{stdId}")
    String updateUser(@PathVariable("stdId") String stdId, Model model) {
        User user = userImplementation.findByStudentId(stdId);
        model.addAttribute("user", user);
        return "update_user";
    }

    @PostMapping("/user")
    String updateUser(User user, Principal principal) {
        User user1 = userImplementation.newUser(user);
        if (user1 != null && user1.getId().equals(user.getId()))
            return "redirect:/manage/user";
        return "redirect:/manage/user";
    }



}
