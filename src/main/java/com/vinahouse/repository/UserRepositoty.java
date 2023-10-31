package com.vinahouse.repository;

import com.vinahouse.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoty extends JpaRepository<User,Integer> {
    public boolean existsByGmail(String gmail);

    public User findByGmail(String gmail);

    public User findByVerifyCode(String code);

    @Query("SELECT u from User u where (:id is null or u.id = :id) and (:gmail is null or u.gmail = :gmail)")
    public User findByIdAndGmail(@Param("id") int id,@Param("gmail") String gmail);
}
