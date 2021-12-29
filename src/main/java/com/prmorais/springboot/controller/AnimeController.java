package com.prmorais.springboot.controller;

import com.prmorais.springboot.dto.AnimeRequestDto;
import com.prmorais.springboot.mapper.AnimeRequestMapper;
import com.prmorais.springboot.dto.AnimeResponseDto;
import com.prmorais.springboot.mapper.AnimeResponseMapper;
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
  private final AnimeResponseMapper responseMapper;

  @GetMapping
  public ResponseEntity<List<AnimeResponseDto>> list() {
    log.info(dateUtil.formatLocalDateTimeToDateStyle(LocalDateTime.now()));
    return ResponseEntity.ok(animeService.list());
  }

  @GetMapping("/find")
  public ResponseEntity<List<AnimeResponseDto>> findByName(@RequestParam String name) {
    log.info(dateUtil.formatLocalDateTimeToDateStyle(LocalDateTime.now()));
    return ResponseEntity.ok(animeService.listByName(name));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AnimeResponseDto> findById(@PathVariable Long id) {
    log.info(dateUtil.formatLocalDateTimeToDateStyle(LocalDateTime.now()));
    return ResponseEntity.ok(animeService.findById(id));
  }

  @PostMapping
  public ResponseEntity<AnimeResponseDto> save(@RequestBody AnimeRequestDto animeDto) {
    AnimeResponseDto animeSaved = animeService.save(animeDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(animeSaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AnimeResponseDto> update(
      @PathVariable Long id,
      @RequestBody AnimeRequestDto animeDto
  ) {
    return ResponseEntity.ok(
        animeService.update(id, animeDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    animeService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
