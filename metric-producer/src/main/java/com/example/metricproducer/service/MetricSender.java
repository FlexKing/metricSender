package com.example.metricproducer.service;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface MetricSender {
    void sendMessage() throws JsonProcessingException;
}