package com.vinahouse.services;

import com.vinahouse.DTO.HostelDTO;
import com.vinahouse.models.Hostel;
import com.vinahouse.repository.HostelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HostelService {
    @Autowired
    private HostelRepo hostelRepo;

    public List<HostelDTO> findAll() {
        List<HostelDTO> list = new ArrayList<>();
        List<Hostel> li = hostelRepo.findAll();
        li.forEach(e ->{
            List<String> im = new ArrayList<>();
            e.getLImages().forEach(a -> im.add(a.getUrl()));
            HostelDTO h = new HostelDTO(e.getId(),e.getTitle(),e.getDescription(),e.getAcreage(),e.getRating(),e.getAddress(),e.getThumbnail()
            ,im,1,e.getRoom(),e.getEmptyroom());
            list.add(h);
        });
        return list;
    }

    public Hostel findById(int id) {
        return hostelRepo.findById(id).get();
    }
}
