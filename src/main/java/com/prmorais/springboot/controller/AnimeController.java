package com.prmorais.springboot.controller;

import com.prmorais.springboot.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {

  @GetMapping
  public List<Anime> list() {
    return List.of(new Anime("DBZ"), new Anime("Berserk"));
  }
}
