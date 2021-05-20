package com.mythden.mythdenbot.miniGames.repository;

import com.mythden.mythdenbot.miniGames.core.Pemain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PemainRepository extends JpaRepository<Pemain, String> {
    Pemain findByPemain(String name);
}
