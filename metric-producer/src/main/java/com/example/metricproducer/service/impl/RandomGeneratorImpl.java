package com.example.metricproducer.service.impl;

import com.example.metricproducer.service.RandomGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorImpl implements RandomGenerator {
    private Random random = new Random();
    private final List<String> deviceIds = Arrays.asList("1", "2", "3","4","5","6","7","8","9");
    @Override
    public String generateIdDevice() {
        return deviceIds.get(random.nextInt(8));
    }
    @Override
    public String generateTemperatureCPU() {
        return String.valueOf(20.0 + (90.0 - 20.0) * random.nextDouble());
    }

    @Override
    public String generateFanSpeed() {
        return String.valueOf(random.nextInt(3600-600)+600);
    }

    @Override
    public String generateFullnessInternalCache() {
        return String.valueOf(random.nextInt(16384));
    }

    @Override
    public String generateSuccessfullySentPackets() {
        return String.valueOf(random.nextInt(65535));
    }

    @Override
    public String generateUnsentPackets() {
        return String.valueOf(random.nextInt(65535));
    }

}
