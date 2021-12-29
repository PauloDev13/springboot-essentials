package com.prmorais.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Schema(name = "Anime Request DTO")
public class AnimeRequestDto implements Serializable {
  @Schema(description = "This is the Anime's name", example = "Speed Racer")
  private String name;
}
