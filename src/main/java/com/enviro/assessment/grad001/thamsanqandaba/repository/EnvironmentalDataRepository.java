package com.enviro.assessment.grad001.thamsanqandaba.repository;

/**
 * Environmental Data Repository
 * Author: thamsanqa 2024
 **/

import com.enviro.assessment.grad001.thamsanqandaba.model.EnvironmentalData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentalDataRepository extends CrudRepository<EnvironmentalData, Long> {
    // No additional methods required, CRUD operations are handled by Spring Data JPA
}