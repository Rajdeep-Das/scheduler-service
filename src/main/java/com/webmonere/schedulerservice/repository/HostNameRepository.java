package com.webmonere.schedulerservice.repository;


import com.webmonere.schedulerservice.model.Hostname;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HostNameRepository extends CrudRepository<Hostname,Long> {
    List<Hostname> findAll();

}
