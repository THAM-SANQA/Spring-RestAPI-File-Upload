package com.enviro.assessment.grad001.thamsanqandaba.model;

/**
 * Environmental Data Model
 * Author: thamsanqa 2024
 **/

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EnvironmentalData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Unique identifier

    // Use a JSON serialization approach to store dynamic data
    @Lob
    @Column(columnDefinition = "TEXT")
    private String dynamicDataJson; // JSON string for dynamic data
}