package com.example.metricproducer.service.impl;

import com.example.metricproducer.dto.MetricDto;
import com.example.metricproducer.service.MetricProducer;
import com.example.metricproducer.service.RandomGenerator;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetricProducerImpl implements MetricProducer {

    private final RandomGenerator randomGenerator;

    @Override
    public MetricDto createMetric() {
        return MetricDto.builder()
                .idMetric(UUID.randomUUID().toString())
                .idDevice(randomGenerator.generateIdDevice())
                .temperature(randomGenerator.generateTemperatureCPU())
                .fanSpeed(randomGenerator.generateFanSpeed())
                .fullnessInternalCache(randomGenerator.generateFullnessInternalCache())
                .successfullySentPackets(randomGenerator.generateSuccessfullySentPackets())
                .unsentPackets(randomGenerator.generateUnsentPackets())
                .build();
    }
}