package com.mythden.mythdenbot.repository;

import com.mythden.mythdenbot.model.Pemain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PemainRepository extends JpaRepository<Pemain, String> {
    Pemain findByPemain(String name);
}
