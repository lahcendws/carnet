package com.example.carnetdevoyage.repository;

import com.example.carnetdevoyage.entity.Etape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapeRepository extends JpaRepository<Etape , Long> {
}
