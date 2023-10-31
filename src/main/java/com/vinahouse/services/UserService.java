package com.vinahouse.services;

import com.vinahouse.models.User;
import com.vinahouse.repository.UserRepositoty;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;

    @Autowired
    private PasswordEncoder encoder;

    public boolean exitsByGmail(String gmail) {
        return userRepositoty.existsByGmail(gmail);
    }

    public int findIdByGmail(String gmail) {
        User u = userRepositoty.findByGmail(gmail);
        return u.getId();
    }

    public User saveRegisterUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepositoty.save(user);
    }

    public User saveUser(User user) {
        return userRepositoty.save(user);
    }

    public User findById(int id) {
        return userRepositoty.findById(id).get();
    }

    public User findbyVericode(String code) {
        return userRepositoty.findByVerifyCode(code);
    }

    public String creatVeriFyCode(){
        return RandomString.make(64);
    }
}
