package com.prmorais.springboot.service;

import com.prmorais.springboot.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService {
  private final List<Anime> animes = List.of(new Anime(1L, "DBZ"), new Anime(2L, "Berserk"));
  public List<Anime> list() {
    return animes;
  }

  public Anime findById(Long id) {
    return animes.stream().filter(anime -> anime.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
            String.format("Anime com ID %s not found", id)));
  }
}
