package com.vinahouse.repository;

import com.vinahouse.models.Hostel;
import com.vinahouse.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {
    @Query("SELECT h from Post h where (:tentro is null or h.title = :tentro) " +
            "and (:thanhpho is null or h.address = :thanhpho) and" +
            " (:loainha is null or h.acreage = :loainha) and (:giamin is null or h.price >= :giamin)" +
            " and (:giamax is null or h.price >= :giamax)")
    public List<Post> findByChoose(@Param("tentro") String tentro, @Param("thanhpho") String thanhpho,
                                     @Param("loainha") String loainha, @Param("giamin") Long pricemin,
                                     @Param("giamax") Long pricemax);
}
