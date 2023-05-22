package com.example.metricparser.service.impl;

import com.example.metricparser.service.AdditionSchedule;
import com.example.metricparser.service.AdditionSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableScheduling
public class AdditionScheduleImpl implements AdditionSchedule {
        private final AdditionSender additionSender;
        @Override
        @Scheduled(cron = "${app.cron}")
        public void schedule() throws Throwable {
            additionSender.sendMessage();
        }
}
