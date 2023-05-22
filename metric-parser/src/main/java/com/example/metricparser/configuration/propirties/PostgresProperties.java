package com.example.metricparser.configuration.propirties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties("postgres")
@Configuration
public class PostgresProperties {
    private  String url;

}
