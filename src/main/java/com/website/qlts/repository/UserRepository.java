package com.website.qlts.repository;

import com.website.qlts.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    @Query(value = "SELECT * FROM users WHERE user_name = :userName", nativeQuery = true)
    Optional<Users> getByUserName(@Param("userName") String userName);

    @Query(value = "SELECT * FROM users WHERE user_name = ?", nativeQuery = true)
    Optional<Users> findByName(String name);
//    @Modifying
//    @Query(value = "UPDATE users r SET r.passWord = ?2 WHERE r.userName = ?1")
//    void updatePasswordByUsername(String userName, String passWord);
}
