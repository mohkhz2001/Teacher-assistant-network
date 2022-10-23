package com.mohkhz.tanetwork.Controller;

import com.mohkhz.tanetwork.Impl.FileImplementation;
import com.mohkhz.tanetwork.Model.Entity.File;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Principal;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 11:47 AM
 */
@Controller
@RequestMapping("/file")
public class FileDownloadController {

    @Autowired
    FileImplementation fileImplementation;

    @RequestMapping(value = "/{fileId}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    void fileDownload(@PathVariable("fileId") String fileId, Principal principal, HttpServletResponse response) {
        File fileItem = fileImplementation.getById(Long.parseLong(fileId));

        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileItem.getLocalAddress());
        response.setHeader("Content-Transfer-Encoding", "binary");

        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis = new FileInputStream("/home/mohammad_kz/temp/download/Files/" + fileItem.getLocalAddress());
            int len;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) > 0) {
                bos.write(buf, 0, len);
            }
            bos.close();
            response.flushBuffer();
        } catch (Exception e) {
            System.out.println();
        }

    }

}
