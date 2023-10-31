package com.vinahouse.repository;

import com.vinahouse.models.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelRepo extends JpaRepository<Hostel,Integer> {
}
