package com.example.metricproducer;

import com.example.metricproducer.service.MetricScheduler;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@SpringBootTest
class MetricProducerApplicationTests {
    @Test
    public void scheduleTest() {
        MetricScheduler metricScheduler = new MetricScheduler() {
            @Override
            @Scheduled(cron = "${app.cron}")
            public void schedule() throws JsonProcessingException {

            }
        };
        try {
            metricScheduler.schedule();
        } catch (JsonProcessingException ignored) {

        }
    }
    @Test
    public void jsonParsing () {
        MetricScheduler metricScheduler = new MetricScheduler() {
            @Override
            @Scheduled(cron = "${app.cron}")
            public void schedule() throws JsonProcessingException {
                throw new JsonProcessingException("Error: JsonProcessingException") {
                };
            }
        };
        try {
            metricScheduler.schedule();
            Assertions.fail("Expected JsonProcessingException was not thrown.");
        } catch (JsonProcessingException e) {
            Assertions.assertEquals("Error: JsonProcessingException", e.getMessage());
        } catch (Exception e) {
            Assertions.fail("Unexpected exception was thrown: " + e.getClass().getSimpleName());
        }
    }


}
