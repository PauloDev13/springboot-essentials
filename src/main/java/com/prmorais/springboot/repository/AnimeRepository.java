package com.prmorais.springboot.repository;

import com.prmorais.springboot.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}