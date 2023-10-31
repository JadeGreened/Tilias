package com.jade.Controller;

import com.jade.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile image) throws Exception {
        log.info("uploaded fileL,{},{},{}",name,age,image);
        String originalFileName = image.getOriginalFilename();
        int index = originalFileName.lastIndexOf(".");
        String exname = originalFileName.substring(index);
        String newFileName = UUID.randomUUID().toString()+exname;
        image.transferTo(new File("D:\\images\\"+newFileName));
        return Result.success();
    };
}
