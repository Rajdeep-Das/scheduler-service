package com.webmonere.schedulerservice.model;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hostname")
public class Hostname {

    public Hostname() {
    }

    public Hostname(String hostname) {
        this.hostname = hostname;
    }

    public Long getHostname_id() {
        return hostname_id;
    }

    public void setHostname_id(Long hostname_id) {
        this.hostname_id = hostname_id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(columnDefinition = "serial") // postgresql
    private Long  hostname_id;
    @Column(nullable = false)
    private String hostname;

}
