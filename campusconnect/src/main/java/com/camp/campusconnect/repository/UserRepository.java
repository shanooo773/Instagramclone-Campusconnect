package com.camp.campusconnect.repository;

import java.util.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.camp.campusconnect.modal.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

    public Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.id IN :users")
    public List<User> findByUserIds(@Param("users") List<Integer> userIds);

    @Query("SELECT DISTINCT u FROM User u WHERE u.username LIKE %:query% OR u.email LIKE %:query%")
    public List<User> findByQuery(@Param("query") String query);

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.id = :userId AND :followingId MEMBER OF u.following")
    void removeFollower(@Param("userId") Integer userId, @Param("followingId") Integer followingId);
}
