package com.prmorais.springboot.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AnimeRequestDto implements Serializable {
  private String name;
}
