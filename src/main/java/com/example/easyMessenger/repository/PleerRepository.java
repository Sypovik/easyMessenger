package com.example.easyMessenger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easyMessenger.model.Pleer;

@Repository
public interface PleerRepository extends JpaRepository<Pleer, Long> {

    List<Pleer> findByName(String name);
}
// ИгровоеПоле