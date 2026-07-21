package com.dane.rover.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OllamaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    // Last time it was seen on that device
    private LocalDate lastSynced;

    // Capabilities
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable (
            name = "ollama_model_capabilities",
            joinColumns = @JoinColumn(name = "ollama_model_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "capability")
    private Set<ModelCapability> capability = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
}
