package com.example.metricproducer.service.impl;

import com.example.metricproducer.service.MetricSender;
import com.example.metricproducer.service.MetricScheduler;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableScheduling
public class MetricSchedulerImpl implements MetricScheduler {

    private final MetricSender metricSender;

    @Override
    @Scheduled(cron = "${app.cron}")
    public void schedule() throws JsonProcessingException {
        metricSender.sendMessage();
    }
}
