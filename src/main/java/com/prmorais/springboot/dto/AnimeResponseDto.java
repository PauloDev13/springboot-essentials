package com.prmorais.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Schema(name = "Anime Response DTO")
public class AnimeResponseDto implements Serializable {
  @Schema(description = "This is the Anime's ID automatic generated")
  private Long id;

  @Schema(description = "This is the Anime's name", example = "Speed Racer")
  private String name;
}
