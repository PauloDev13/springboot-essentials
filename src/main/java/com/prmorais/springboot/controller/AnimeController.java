package com.prmorais.springboot.controller;

import com.prmorais.springboot.dto.AnimeRequestDto;
import com.prmorais.springboot.mapper.AnimeRequestMapper;
import com.prmorais.springboot.dto.AnimeResponseDto;
import com.prmorais.springboot.mapper.AnimeResponseMapper;
import com.prmorais.springboot.service.AnimeService;
import com.prmorais.springboot.util.DateUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Anime", description = "The Anime API")
public class AnimeController {

  private final DateUtil dateUtil;
  private final AnimeService animeService;

  @GetMapping
  @Operation(summary = "List all Animes")
  public ResponseEntity<List<AnimeResponseDto>> list() {
    log.info(dateUtil.formatLocalDateTimeToDateStyle(LocalDateTime.now()));
    return ResponseEntity.ok(animeService.list());
  }

  @GetMapping("/find")
  @Operation(summary = "List all Animes by name")
  public ResponseEntity<List<AnimeResponseDto>> findByName(@RequestParam String name) {
    log.info(dateUtil.formatLocalDateTimeToDateStyle(LocalDateTime.now()));
    return ResponseEntity.ok(animeService.listByName(name));
  }

  @GetMapping("/{id}")
  @Operation(summary = "Return one Anime by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful Operation"),
      @ApiResponse(responseCode = "404", description = "When Anime Does Not Exist in The Database"),
  })
  public ResponseEntity<AnimeResponseDto> findById(@PathVariable Long id) {
    log.info(dateUtil.formatLocalDateTimeToDateStyle(LocalDateTime.now()));
    return ResponseEntity.ok(animeService.findById(id));
  }

  @PostMapping
  @Operation(summary = "Save Animes")
  public ResponseEntity<AnimeResponseDto> save(@RequestBody AnimeRequestDto animeDto) {
    AnimeResponseDto animeSaved = animeService.save(animeDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(animeSaved);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update Animes")
  public ResponseEntity<AnimeResponseDto> update(
      @PathVariable Long id,
      @RequestBody AnimeRequestDto animeDto
  ) {
    return ResponseEntity.ok(
        animeService.update(id, animeDto));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete Animes")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Successful Operation"),
      @ApiResponse(responseCode = "400", description = "When Anime Does Not Exist in The Database"),
  })
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    animeService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
