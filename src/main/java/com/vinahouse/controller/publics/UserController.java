package com.vinahouse.controller.publics;

import com.vinahouse.models.User;
import com.vinahouse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user/{id}")
    public User home(@PathVariable("id") String id) {
        int x = Integer.valueOf(id);
        return userService.findById(x);
    }
}
