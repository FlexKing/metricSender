package com.example.metricproducer.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class MetricDto {

    String idMetric;
    String idDevice;
    String temperature;
    String fanSpeed;
    String fullnessInternalCache;
    String successfullySentPackets;
    String unsentPackets;

}