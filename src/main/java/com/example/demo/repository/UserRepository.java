package com.example.demo.repository;

import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("select u from User as u where lower(u.name) like %:name%")
    List<User> findByNameContainingIgnoreCase(@Param("name") String name);

    @EntityGraph(attributePaths = {"orders","orders.items","orders.items.product"})
    @Query("select u from User u")
    List<User> findAllWithOrders();

    @EntityGraph(attributePaths = {"orders", "orders.items", "orders.items.product"})
    @Query("select u from User u where u.id = :id")
    Optional<User> findUserWithOrdersById(Long id);

    @Query("SELECT SUM(i.price * i.quantity) " +
            "FROM OrderItem i " +
            "JOIN i.order o " +
            "JOIN o.user u " +
            "WHERE u.id = :userId")
    BigDecimal getTotalPriceByUserId(@Param("userId") Long userId);

    Optional<User> findUserByName(String name);
}
