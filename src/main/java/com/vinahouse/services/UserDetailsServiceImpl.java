package com.vinahouse.services;

import com.vinahouse.models.User;
import com.vinahouse.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositoty userRepositoty;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException {
        User user = userRepositoty.findByGmail(gmail);
        if(user!=null) {
            return new UserDetailsImpl(user);
        }else {
            return (UserDetails) new UsernameNotFoundException("Thong tin tai khoan khong chinh xac");
        }
    }
}
