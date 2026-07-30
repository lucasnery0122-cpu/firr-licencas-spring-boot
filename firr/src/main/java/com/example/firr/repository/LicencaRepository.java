package com.example.firr.repository;

import com.example.firr.model.Licenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicencaRepository extends JpaRepository<Licenca, Long> {
}