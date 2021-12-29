package com.prmorais.springboot.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AnimeResponseDto implements Serializable {
  private Long id;
  private String name;
}
