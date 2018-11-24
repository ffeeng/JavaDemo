package com.fileupload;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FileUploadController {

    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");

        String path = "E:\\ideaWorkspace\\demo\\src\\main\\webapp\\WEB-INF\\upload\\"+sdf.format(new Date())+file.getOriginalFilename();
        File f = new File(path);
        FileOutputStream fos = new FileOutputStream(f);

        InputStream is = file.getInputStream();
        IOUtils.copy(is,fos);
        is.close();
        fos.close();

        return "redirect:/uploadStatus";
    }


    @RequestMapping("uploadStatus")
    @ResponseBody
    public String uploadStatus(){
        return "upload success";
    }

}
