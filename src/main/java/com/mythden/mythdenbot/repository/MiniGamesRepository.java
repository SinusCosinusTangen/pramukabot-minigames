package com.mythden.mythdenbot.repository;

import com.mythden.mythdenbot.model.Pertanyaan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniGamesRepository extends JpaRepository<Pertanyaan, Integer> {
    Pertanyaan findById(int id);
}
