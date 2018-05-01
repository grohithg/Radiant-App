package com.example.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "service_visits")
public class ServiceVisit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String serviceName;

    private LocalDateTime createdAt;

    public ServiceVisit(String serviceName) {
        this.serviceName = serviceName;
    }
}
