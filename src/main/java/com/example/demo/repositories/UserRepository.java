package com.example.demo.repositories;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{
    @Query("select u from User as u where lower(u.name) like %:name%")
    List<User> findByNameContainingIgnoreCase(@Param("name") String name);

}
