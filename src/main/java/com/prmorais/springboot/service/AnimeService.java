package com.prmorais.springboot.service;

import com.prmorais.springboot.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
  private static final List<Anime> animes;

  static {
    animes = new ArrayList<>(
        List.of(new Anime(1L, "DBZ"), new Anime(2L, "Berserk"))
    );
  }

  public List<Anime> list() {
    return animes;
  }

  public Anime findById(Long id) {
    return animes.stream().filter(anime -> anime.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
            String.format("Anime com ID %s not found", id)));
  }

  public Anime save(Anime anime) {
    anime.setId(ThreadLocalRandom.current().nextLong(3, 1000));
    animes.add(anime);
    return anime;
  }

  public void delete(Long id) {
   animes.remove(findById(id));
  }
}
