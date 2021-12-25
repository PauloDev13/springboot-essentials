package com.prmorais.springboot.mapper;

import com.prmorais.springboot.domain.Anime;
import com.prmorais.springboot.dto.AnimeRequestDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AnimeRequestMapper {

  @Mapping(target = "id", ignore = true)
  Anime toAnime(AnimeRequestDto animeRequestDto);

}
