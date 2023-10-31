package com.vinahouse.thuetro;

import com.vinahouse.models.Role;
import com.vinahouse.models.User;
import com.vinahouse.repository.UserRepositoty;
import com.vinahouse.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@ComponentScan({"com.vinahouse.services","com.vinahouse.security"})
public class UserTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepositoty userRepositoty;


    @Test
    public void createUser(){
        User u = new User("hoanga@gmail.com","hoan123");
        u.addRole(new Role(1));
        User luu = userService.saveUser(u);
        Assertions.assertTrue(luu.getId() > 0);
    }

    @Test
    public void updateUser() {
        User u = new User();
        User luu = userService.saveUser(u);
        Assertions.assertTrue(luu.getId() > 0);
    }

    @Test
    void findById() {
        int id = 3;
        User u = userRepositoty.findByIdAndGmail(3,null);
        Assertions.assertTrue(u != null);
    }
}
