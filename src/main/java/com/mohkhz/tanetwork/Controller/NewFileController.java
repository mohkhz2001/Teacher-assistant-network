package com.mohkhz.tanetwork.Controller;

import com.mohkhz.tanetwork.Impl.FileImplementation;
import com.mohkhz.tanetwork.Model.Entity.File;
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
 * @create 21 October 2022 at 12:58 PM
 */
@Controller
@RequestMapping("/new/file")
public class NewFileController {

    @Autowired
    FileImplementation fileImplementation;

    @ModelAttribute("file")
    File newFile() {
        return new File();
    }

    @GetMapping
    String showPage() {
        return "new_file";
    }

    @PostMapping
    String saveFile(File file) {

        fileImplementation.addNewFile(file);

        return "redirect:/manage/file";
    }

}
