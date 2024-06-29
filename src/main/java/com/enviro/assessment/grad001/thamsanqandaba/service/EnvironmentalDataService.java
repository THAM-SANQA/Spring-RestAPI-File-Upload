package com.enviro.assessment.grad001.thamsanqandaba.service;

/**
 * Environmental Data Service
 * Author: thamsanqa 2024
 **/

import com.enviro.assessment.grad001.thamsanqandaba.model.EnvironmentalData;
import com.enviro.assessment.grad001.thamsanqandaba.repository.EnvironmentalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentalDataService {

    @Autowired
    private EnvironmentalDataRepository repository; // Repository for data operations

    // Save all data to the repository
    public void saveAllData(List<EnvironmentalData> dataList) {
        repository.saveAll(dataList);
    }

    // Retrieve all data from the repository
    public List<EnvironmentalData> getAllData() {
        return (List<EnvironmentalData>) repository.findAll();
    }
}