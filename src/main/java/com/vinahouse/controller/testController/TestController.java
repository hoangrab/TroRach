package com.vinahouse.controller.testController;

import com.vinahouse.models.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
public class TestController {
    @PostMapping("/test/upfile")
    public ResponseEntity upload(@RequestParam("file_upload")MultipartFile[] multipartFiles) {
        Arrays.asList(multipartFiles).stream().forEach(e -> System.out.println(e.getOriginalFilename()));
        return ResponseEntity.ok(new MessageResponse("uploadok",1));
    }
}
