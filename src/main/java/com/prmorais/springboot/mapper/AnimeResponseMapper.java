package com.prmorais.springboot.mapper;

import com.prmorais.springboot.domain.Anime;
import com.prmorais.springboot.dto.AnimeResponseDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AnimeResponseMapper {

  Anime toAnime(AnimeResponseDto animeResponseDto);

  AnimeResponseDto toDto(Anime anime);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateAnimeFromDto(AnimeResponseDto animeResponseDto, @MappingTarget Anime anime);
}
