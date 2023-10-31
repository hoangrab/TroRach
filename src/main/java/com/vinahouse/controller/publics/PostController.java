package com.vinahouse.controller.publics;

import com.vinahouse.DTO.PostDTO;
import com.vinahouse.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public List<PostDTO> home() {
        return postService.findAll();
    }
}
