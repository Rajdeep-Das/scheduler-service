package com.webmonere.schedulerservice.service;

import com.webmonere.schedulerservice.model.Hostname;
import com.webmonere.schedulerservice.repository.HostNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HostnameService {

    @Autowired
    HostNameRepository hostNameRepository;
    @Transactional
    public List<Hostname> getAllHostNames()
    {
        return  hostNameRepository.findAll();
    }
}
