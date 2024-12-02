package com.example.easyMessenger.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easyMessenger.model.MessengerUser;

@Repository
public interface MessengerUserRepository extends JpaRepository<MessengerUser, Long> {

    // List<User> findByName(Long name);
}
