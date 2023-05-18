package com.example.metricproducer.service;

public interface RandomGenerator {
    String generateIdDevice();
    String generateTemperatureCPU();
    String generateFanSpeed();
    String generateFullnessInternalCache();
    String generateSuccessfullySentPackets();
    String generateUnsentPackets();
}
