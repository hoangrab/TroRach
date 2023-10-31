package com.vinahouse.thuetro;

import com.vinahouse.models.Role;
import com.vinahouse.services.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@ComponentScan({"com.vinahouse.services","com.vinahouse.security"})
public class RoleTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void addRole() {
        Role role = new Role("ROLE_ADMIN","Chuyên chơi đá");
        Role luu = roleService.saveRole(role);
        Assertions.assertTrue(luu.getId() > 0);
    }

}
