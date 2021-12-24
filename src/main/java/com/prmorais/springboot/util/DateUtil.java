package com.prmorais.springboot.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
  public String formatLocalDateTimeToDateStyle(LocalDateTime date) {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(date);
  }
}
