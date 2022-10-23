package com.mohkhz.tanetwork.Controller;

import com.mohkhz.tanetwork.Impl.FileImplementation;
import com.mohkhz.tanetwork.Impl.UserImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import retrofit2.http.GET;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 22 October 2022 at 6:57 PM
 */
@Controller
@RequestMapping("/delete")
public class DeleteController {

    @Autowired
    FileImplementation fileImplementation;

    @Autowired
    UserImplementation userImplementation;

    @GetMapping("/user/{stdId}")
    String deleteUser(@PathVariable("stdId") Long stdId) {
        userImplementation.deleteUser(stdId);
        return "redirect:/manage/user";
    }

    @GetMapping("/file/{fId}")
    String deleteFile(@PathVariable("fId") Long fId) {
        fileImplementation.deleteFile(fId);
        return "redirect:/manage/file";
    }
}
