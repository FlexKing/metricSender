package com.example.metricparser.controllers;

import com.example.metricparser.entity.Addition;
import com.example.metricparser.repository.AdditionRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class AdditionRepositoryController {
    @Autowired
    private final AdditionRepository additionRepository;

    public AdditionRepositoryController(AdditionRepository additionRepository) {
        this.additionRepository = additionRepository;
    }

    @GetMapping("/addition/{id}")
    public ResponseEntity<Addition> getAdditionByRandomId(@PathVariable(value = "id") Long additionId)
            throws Throwable {
        Addition addition = (Addition) additionRepository.findById(additionId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + additionId));
        return ResponseEntity.ok().body(addition);
    }
}
