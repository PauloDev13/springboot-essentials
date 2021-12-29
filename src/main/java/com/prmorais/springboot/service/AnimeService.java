package com.prmorais.springboot.service;

import com.prmorais.springboot.domain.Anime;
import com.prmorais.springboot.dto.AnimeRequestDto;
import com.prmorais.springboot.dto.AnimeResponseDto;
import com.prmorais.springboot.exception.BadRequestException;
import com.prmorais.springboot.mapper.AnimeRequestMapper;
import com.prmorais.springboot.mapper.AnimeResponseMapper;
import com.prmorais.springboot.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimeService {
  private final AnimeRepository animeRepository;
  private final AnimeRequestMapper animeRequestMapper;
  private final AnimeResponseMapper animeResponseMapper;

  public List<AnimeResponseDto> list() {
    return animeRepository.findAll()
        .stream()
        .map(animeResponseMapper::toDto)
        .collect(Collectors.toList());
  }

  public List<AnimeResponseDto> listByName(String name) {
    return animeRepository.findByName(name)
        .stream()
        .map(animeResponseMapper::toDto)
        .collect(Collectors.toList());
  }

  public AnimeResponseDto findById(Long id) {
    return animeResponseMapper.toDto(animeRepository.findById(id)
        .orElseThrow(() -> new BadRequestException(String.format("Anime com ID %s not found", id))));
  }

  public AnimeResponseDto save(AnimeRequestDto animeDto) {
    Anime anime = animeRepository.save(animeRequestMapper.toAnime(animeDto));
    return animeResponseMapper.toDto(anime);
  }

  public AnimeResponseDto update(Long id, AnimeRequestDto animeDto) {
    Anime animeUpdated = animeResponseMapper.toAnime(findById(id));
//    BeanUtils.copyProperties(animeDto, animeUpdated, "id");
     animeRequestMapper.updateAnime(animeDto, animeUpdated);
    return animeResponseMapper.toDto(animeRepository.save(animeUpdated));
  }

  public void delete(Long id) {
    findById(id);
    animeRepository.deleteById(id);
  }

}
