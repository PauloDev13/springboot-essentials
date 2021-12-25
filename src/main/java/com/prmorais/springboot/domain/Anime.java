package com.prmorais.springboot.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "anime")
public class Anime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false)
  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Anime anime = (Anime) o;
    return Objects.equals(name, anime.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
