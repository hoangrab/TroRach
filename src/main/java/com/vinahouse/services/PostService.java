package com.vinahouse.services;

import com.vinahouse.DTO.HostelDTO;
import com.vinahouse.DTO.PostDTO;
import com.vinahouse.models.Hostel;
import com.vinahouse.models.Post;
import com.vinahouse.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public List<PostDTO> findAll() {
        List<PostDTO> list = new ArrayList<>();
        List<Post> li = postRepo.findAll();
        li.forEach(e ->{
            List<String> im = new ArrayList<>();
            e.getLImage().forEach(t -> im.add(t.getUrl()));
            PostDTO h = new PostDTO(e.getId(),e.getTitle(),e.getPrice(),e.getAcreage(),e.getAddress(),e.getDescription(), e.getThumbnail(),e.getDay(),e.getType(),e.getKind(),e.getJuridical(),e.getUser().getId(),im);
            list.add(h);
        });
        return list;
    }
}
