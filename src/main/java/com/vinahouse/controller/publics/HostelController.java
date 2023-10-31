package com.vinahouse.controller.publics;

import com.vinahouse.DTO.HostelDTO;
import com.vinahouse.models.Hostel;
import com.vinahouse.services.HostelService;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HostelController {
    @Autowired
    private HostelService hostelService;
    @GetMapping("/hostel")
    public List<HostelDTO> home() {
        return hostelService.findAll();
    }

    @GetMapping("/hostel/{id}")
    public Hostel home1(@PathVariable("id") String id) {
        return hostelService.findById(Integer.valueOf(id));
    }
}
