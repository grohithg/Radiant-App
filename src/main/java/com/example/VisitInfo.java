package com.example;

import lombok.Data;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;


@Data
public class VisitInfo {

    private ZonedDateTime timestamp = ZonedDateTime.ofInstant(Instant.now(), TimeZone.getTimeZone("EST").toZoneId());
    private long calls;
    private String  service;
}
