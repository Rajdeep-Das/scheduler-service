package com.webmonere.schedulerservice;

import com.webmonere.schedulerservice.model.Hostname;
import com.webmonere.schedulerservice.service.HostnameService;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {
    @Autowired
    HostnameService hostnameService;
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Value("${http-stat-service-url}")
    private String HTTP_STAT_SERVICE_URL;

    @Scheduled(fixedRate = 30000)
    public void scheduleTaskWithFixedRate() {

        logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
        logger.info(hostnameService.getAllHostNames().toString());

        if(!hostnameService.getAllHostNames().isEmpty()) {
            for (Hostname hostname : hostnameService.getAllHostNames()) {
               final String uid = String.valueOf(hostname.getHostname_id());
               final String url = hostname.getHostname();

                Unirest.post(HTTP_STAT_SERVICE_URL)
                        .field("uid", uid)
                        .field("url",url).asEmptyAsync();
            }
        }
        System.out.println(HTTP_STAT_SERVICE_URL);

    }

    public void scheduleTaskWithFixedDelay() {}

    public void scheduleTaskWithInitialDelay() {}

    public void scheduleTaskWithCronExpression() {}
}
