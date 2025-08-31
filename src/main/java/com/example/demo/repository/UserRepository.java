package com.example.demo.repository;

import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("select u from User as u where lower(u.name) like %:name%")
    List<User> findByNameContainingIgnoreCase(@Param("name") String name);

    @Transactional
    @Query("update User u set u.email=:email where u.id=:id")
    @Modifying
    int updateUserEmailById(@Param("id")  Long id, @Param("email") String email);

    @EntityGraph(attributePaths = {"orders"})
    @Query("select u from User u")
    List<User> findAllWithOrders();

    Optional<User> findUserWithOrdersById(Long id);
}
