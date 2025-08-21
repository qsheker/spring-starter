package com.example.demo.repositories;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{
    @Query("select u from User as u where lower(u.name) like %:name%")
    List<User> findByNameContainingIgnoreCase(@Param("name") String name);

    @Transactional
    @Query("update User u set u.email=:email where u.id=:id")
    @Modifying
    int updateUserEmailById(@Param("id")  Long id, @Param("email") String email);

}
