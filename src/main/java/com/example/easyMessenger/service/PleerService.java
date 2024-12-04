package com.example.easyMessenger.service;

import org.springframework.stereotype.Service;

import com.example.easyMessenger.model.Pleer;
import com.example.easyMessenger.repository.PleerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PleerService {

    private final PleerRepository pleerRepository;

    public PleerService(PleerRepository pleerRepository) {
        this.pleerRepository = pleerRepository;
    }

    public Pleer addPleers(Pleer pleer) {
        if (pleerRepository.findById(pleer.getId()).isEmpty()) {
            return pleerRepository.save(pleer);
        } else {
            throw new RuntimeException("Pleer already exists");
        }
    }

    public List<Pleer> getAllPleers() {
        return new ArrayList<>(pleerRepository.findAll());
    }

}