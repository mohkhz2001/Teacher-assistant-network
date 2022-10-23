package com.mohkhz.tanetwork.Controller;

import com.mohkhz.tanetwork.Impl.FileImplementation;
import com.mohkhz.tanetwork.Impl.UserImplementation;
import com.mohkhz.tanetwork.Model.Entity.File;
import com.mohkhz.tanetwork.Model.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 2:52 AM
 */
@Controller
@RequestMapping("/list/file")
public class FileListController {

    @Autowired
    FileImplementation fileImplementation;

    @Autowired
    UserImplementation userImplementation;

    @ModelAttribute("fileList")
    List<File> getFileList(Principal principal) {
        List<File> list = fileImplementation.getAll();
        return list;
    }

    @ModelAttribute("username")
    String setUsername(Principal principal) {
        System.out.println(principal.getName());
        User user = userImplementation.findByStudentId(principal.getName());
        return user.getFullName();
    }

    @GetMapping
    String showPage() {
        return "download_list";
    }

}
