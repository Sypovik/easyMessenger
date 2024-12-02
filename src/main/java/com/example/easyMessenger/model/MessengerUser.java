package com.example.easyMessenger.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MessengerUser")
public class MessengerUser {
    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    public MessengerUser(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
