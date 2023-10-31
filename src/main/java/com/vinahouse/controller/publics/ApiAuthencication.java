package com.vinahouse.controller.publics;

import com.vinahouse.controller.GlobalExceptionHandler;
import com.vinahouse.models.Role;
import com.vinahouse.models.User;
import com.vinahouse.models.payload.request.LoginRequest;
import com.vinahouse.models.payload.request.SignupRequest;
import com.vinahouse.models.payload.response.JwtResponse;
import com.vinahouse.models.payload.response.MessageResponse;
import com.vinahouse.security.jwt.JwtUtils;
import com.vinahouse.services.MailService;
import com.vinahouse.services.RoleService;
import com.vinahouse.services.UserDetailsImpl;
import com.vinahouse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiAuthencication {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/api/auth/signup")
    public ResponseEntity signUp(@RequestBody @Valid SignupRequest signupRequest) throws MessagingException {
        User user = new User();
        user.setRoles(null);
        if(userService.exitsByGmail(signupRequest.getGmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Gmail da ton tai",1));
        }
        else{
            user.setDisplayName(signupRequest.getName());
            user.setGmail(signupRequest.getGmail());
            user.setPassword(signupRequest.getPassword());
            user.setPhone(signupRequest.getPhone());
            user.setRoles(List.of(new Role(1)));
            user.setEnabled(false);
            String veriCode = userService.creatVeriFyCode();
            user.setVerifyCode(veriCode);
            userService.saveRegisterUser(user);
            mailService.sendMail(user.getGmail(),veriCode);
            return ResponseEntity.ok(new MessageResponse("Hãy mở gmail ra để xác thực tài khoản",2));
        }
    }

    @PostMapping("/api/auth/signin")
    public ResponseEntity signIn(@RequestBody LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getGmail(),loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = new ArrayList<>();
            userDetails.getAuthorities().forEach(e -> roles.add(e.getAuthority()));
            return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getUsername(),roles,1,userService.findIdByGmail(loginRequest.getGmail().trim())));
        }catch (Exception e) {
            System.out.println("co loi: " + e);
            return ResponseEntity.badRequest().body(new MessageResponse("Thong tin tai khoan hoac mat khau khong chinh xãc",0));
        }
    }

    @GetMapping("api/auth/verify")
    public ResponseEntity<?> verifyCode(@RequestParam("code") String code){
        User u = userService.findbyVericode(code);
        if(u==null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Code không hợp lệ!!!",1));
        }
        u.setVerifyCode(null);
        u.setEnabled(true);
        userService.saveUser(u);
        return ResponseEntity.ok(new MessageResponse("Đã xác thực thành công",1));
    }

    @PostMapping("/api/auth/luuRole")
    public ResponseEntity<?> luuRole(@RequestBody Role role) {
        Role u1 = roleService.saveRole(role);
        return ResponseEntity.ok(new MessageResponse("Da luu thanh cong role",1));
    }

    @GetMapping("/api/auth/gmail")
    public void sendMail(@RequestParam("email") String email,@RequestParam("code") String code) throws MessagingException {
        mailService.sendMail(email,code);
    }
}
