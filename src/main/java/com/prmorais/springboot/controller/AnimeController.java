package com.prmorais.springboot.controller;

import com.prmorais.springboot.domain.Anime;
import com.prmorais.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/animes")
public class AnimeController {

  private final DateUtil dateUtil;

  @GetMapping
  public List<Anime> list() {
    log.info(dateUtil.formatLocalDateTimeToDateStyle(LocalDateTime.now()));
    return List.of(new Anime("DBZ"), new Anime("Berserk"));
  }
}
