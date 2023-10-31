package com.vinahouse.controller.admin;

import com.vinahouse.models.Role;
import com.vinahouse.models.User;
import com.vinahouse.models.payload.response.MessageResponse;
import com.vinahouse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiCommon {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public ResponseEntity<?> home() {
        return ResponseEntity.ok(new MessageResponse("ok nha con",1));
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String hom1() {
        return "Day la trang danh cho USER";
    }

    @GetMapping("/api/auth/addRole")
    public String daADD() {
        User u = userService.findById(4);
        u.addRole(new Role(1));
        userService.saveUser(u);
        return "Da add thanh cong";
    }

}
