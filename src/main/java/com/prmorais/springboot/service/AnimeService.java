package com.prmorais.springboot.service;

import com.prmorais.springboot.domain.Anime;
import com.prmorais.springboot.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {
  private final AnimeRepository animeRepository;

  public List<Anime> list() {
    return animeRepository.findAll();
  }

  public List<Anime> listByName(String name) {
    return animeRepository.findByName(name);
  }

  public Anime findById(Long id) {
    return animeRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
            String.format("Anime com ID %s not found", id)));
  }

  public Anime save(Anime anime) {
    return animeRepository.save(anime);
  }

  public Anime update(Long id, Anime anime) {
    Anime animeUpdated = findById(id);
    BeanUtils.copyProperties(anime, animeUpdated, "id");
    return animeRepository.save(animeUpdated);
  }

  public void delete(Long id) {
    findById(id);
    animeRepository.deleteById(id);
  }

}
