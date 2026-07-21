package com.dane.rover.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String name = "";
    String ollama_endpoint = "";

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OllamaModel> models;
    boolean isAvailable = false;


}
