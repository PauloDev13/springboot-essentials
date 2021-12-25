package com.prmorais.springboot.controller;

import com.prmorais.springboot.domain.Anime;
import com.prmorais.springboot.dto.AnimeRequestDto;
import com.prmorais.springboot.mapper.AnimeRequestMapper;
import com.prmorais.springboot.service.AnimeService;
import com.prmorais.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/animes")
public class AnimeController {

  private final DateUtil dateUtil;
  private final AnimeService animeService;
  private final AnimeRequestMapper requestMapper;

  @GetMapping
  public ResponseEntity<List<Anime>> list() {
    log.info(dateUtil.formatLocalDateTimeToDateStyle(LocalDateTime.now()));
    return ResponseEntity.ok(animeService.list());
  }

  @GetMapping("/find")
  public ResponseEntity<List<Anime>> findByName(@RequestParam String name) {
    log.info(dateUtil.formatLocalDateTimeToDateStyle(LocalDateTime.now()));
    return ResponseEntity.ok(animeService.listByName(name));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Anime> findById(@PathVariable Long id) {
    log.info(dateUtil.formatLocalDateTimeToDateStyle(LocalDateTime.now()));
    return ResponseEntity.ok(animeService.findById(id));
  }

  @PostMapping
  public ResponseEntity<Anime> save(@RequestBody AnimeRequestDto animeDto) {
    Anime animeSaved = animeService.save(requestMapper.toAnime(animeDto));
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(animeSaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Anime> update(
      @PathVariable Long id,
      @RequestBody AnimeRequestDto animeDto
  ) {
    return ResponseEntity.ok(
        animeService.update(id, requestMapper.toAnime(animeDto)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    animeService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
