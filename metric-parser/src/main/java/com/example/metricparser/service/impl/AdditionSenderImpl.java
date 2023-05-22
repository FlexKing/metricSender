package com.example.metricparser.service.impl;

import com.example.metricparser.configuration.propirties.KafkaProperties;
import com.example.metricparser.controllers.AdditionRepositoryController;
import com.example.metricparser.service.AdditionSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdditionSenderImpl implements AdditionSender {
    private final KafkaProperties kafkaProperties;
    private final AdditionRepositoryController additionRepositoryController;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage() throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        kafkaTemplate.send(kafkaProperties.getTopic(),objectMapper.writeValueAsString(additionRepositoryController.getAdditionByRandomId((long) ((Math.random() * ((9) + 1)) + 0))));
    }
}
