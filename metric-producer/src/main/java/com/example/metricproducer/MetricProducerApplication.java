package com.example.metricproducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MetricProducerApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(MetricProducerApplication.class, args);
    }

}
