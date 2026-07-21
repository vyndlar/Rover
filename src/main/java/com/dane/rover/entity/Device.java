package com.dane.rover.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String name;
    String ollama_endpoint;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OllamaModel> models;
    boolean isAvailable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOllama_endpoint() {
        return ollama_endpoint;
    }

    public void setOllama_endpoint(String ollama_endpoint) {
        this.ollama_endpoint = ollama_endpoint;
    }

    public List<OllamaModel> getModels() {
        return models;
    }

    public void setModels(List<OllamaModel> models) {
        this.models = models;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
