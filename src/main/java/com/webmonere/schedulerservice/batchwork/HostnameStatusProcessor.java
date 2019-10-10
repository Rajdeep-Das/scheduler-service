package com.webmonere.schedulerservice.batchwork;

import com.webmonere.schedulerservice.model.Hostname;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class HostnameStatusProcessor implements ItemProcessor<Hostname,Hostname> {
    private static final Logger log = LoggerFactory.getLogger(HostnameStatusProcessor.class);
    @Override
    public Hostname process(Hostname hostname) throws Exception {

        final String  url = hostname.getHostname();
        final String  id  = String.valueOf( hostname.getHostname_id());

        log.info("Converting (" + url + ") into (" + id + ")");

        return hostname;
    }
}
