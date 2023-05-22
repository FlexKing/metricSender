package com.example.metricparser.configuration.propirties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties("kafka")
@Configuration
public class KafkaProperties {

    private String bootstrapServers;
    private String topic;
}