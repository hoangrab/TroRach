package com.vinahouse.thuetro;

import com.vinahouse.models.Hostel;
import com.vinahouse.models.Images;
import com.vinahouse.models.User;
import com.vinahouse.repository.HostelRepo;
import com.vinahouse.repository.ImagesRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@ComponentScan({"com.vinahouse.services","com.vinahouse.security"})
public class HostelTest {
    @Autowired
    private ImagesRepo imagesRepo;
    @Autowired
    private HostelRepo hostelRepo;
    @Test
    void taoAnh() {
        Images i1 = new Images("https://i.dummyjson.com/data/products/1/2.jpg");
        Images i2 = new Images("https://i.dummyjson.com/data/products/1/3.jpg");
        Images i3 = new Images("https://i.dummyjson.com/data/products/1/4.jpg");
        Images i4 = new Images("https://i.dummyjson.com/data/products/1/thumbnail.jpg");
        imagesRepo.saveAll(List.of(i1,i2,i3,i4));
        Assertions.assertTrue(1 > 0);
    }

    @Test
    void taoHostel() {
        List<Images> ima = new ArrayList<>();
        ima.add(new Images("https://i.dummyjson.com/data/products/1/2.jpg"));
        ima.add(new Images("https://i.dummyjson.com/data/products/1/3.jpg"));
        User u = new User(3);
        Hostel h1 = new Hostel("Nhà trọ Bá Vương","Mang cả đáy biển đến ngôi nhà của bạn",12000,34,5,"Hà Nội","https://media.vneconomy.vn/w900/images/upload/2021/09/04/can2.png",ima,4,5,u);
        Hostel s = hostelRepo.save(h1);
        Assertions.assertTrue(s.getId() > 0);
    }
}
