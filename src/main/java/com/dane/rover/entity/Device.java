package com.dane.rover.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String name;
    String ollama_endpoint;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<OllamaModel> models;
    boolean isAvailable;

    public long getId() {
        return id;
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

    public Set<OllamaModel> getModels() {
        return models;
    }

    public void addModel(OllamaModel model) {
        this.models.add(model);
    }

    public void deleteModel(OllamaModel model) {
        this.models.remove(model);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
