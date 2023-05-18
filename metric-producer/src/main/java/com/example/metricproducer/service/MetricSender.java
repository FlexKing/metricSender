package com.example.metricproducer.service;


import com.example.metricproducer.dto.MetricDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface MetricSender {
    void sendMessage() throws JsonProcessingException;
}