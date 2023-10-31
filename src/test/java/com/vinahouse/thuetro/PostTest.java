package com.vinahouse.thuetro;

import com.vinahouse.models.Images;
import com.vinahouse.models.Post;
import com.vinahouse.models.User;
import com.vinahouse.repository.PostRepo;
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
public class PostTest {

    @Autowired
    private PostRepo postRepo;
    @Test
    void createPost() {
        Post post = new Post();
        post.setTitle("Cho thuê ký túc xá tư nhân giá rẻ bao trọn gói giờ giấc tự do");
        post.setPrice(3);
        post.setAcreage(28);
        post.setAddress("TP.Hồ Chí Minh");
        post.setDescription("+ PHÒNG CÓ NỘI THẤT: máy lạnh, tủ áo, bàn ăn cơm, giường, nệm, quạt, tivi,..");
        post.setThumbnail("https://cloud.mogi.vn/images/2021/10/09/576/c21f1401f76247c1afddf9c02ea16edf.jpg");
        post.setDay("14/09/2023");
        post.setType("rent");
        post.setKind("căn hộ");
        post.setJuridical("Không xác định");
        User u = new User(3);
        post.setUser(u);
        List<Images> li = new ArrayList<>();
        li.add(new Images("https://cloud.mogi.vn/images/2021/10/09/576/c21f1401f76247c1afddf9c02ea16edf.jpg"));
        li.add(new Images("https://cloud.mogi.vn/images/2023/04/09/263/b401b6fa83694dd497e1b674e3451591.jpg"));
        li.add(new Images("https://cloud.mogi.vn/images/2023/09/28/266/b3259cfb0fb14bfd9a822096450b26a6.jpg"));
        li.add(new Images("https://cloud.mogi.vn/images/2023/03/27/528/4d47a49b1d0d44a5ad157e1e88f2df5c.jpg"));
        li.add(new Images("https://cloud.mogi.vn/images/2023/10/10/178/ed1ef9df825040adbe7f85d71934a5b8.jpg"));
        post.setLImage(li);
        Post p = postRepo.save(post);
        Assertions.assertTrue(p.getId() > 0);
    }
}
