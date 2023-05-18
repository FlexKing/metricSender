package com.example.metricproducer.service.impl;

import com.example.metricproducer.configuration.propirties.AppProperties;
import com.example.metricproducer.configuration.propirties.KafkaProperties;
import com.example.metricproducer.service.MetricProducer;
import com.example.metricproducer.service.MetricSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MetricSenderImpl implements MetricSender {

    private final KafkaProperties kafkaProperties;
    private final AppProperties appProperties;
    private final MetricProducer metricProducer;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //TODO intStream ParrallelStream
        for (int i = 0; i < appProperties.getBatchSize(); i++) {
            kafkaTemplate.send(kafkaProperties.getTopic(), //TODO добавить ключ
                    objectMapper.writeValueAsString(metricProducer.createMetric()));
        }
    }
}
