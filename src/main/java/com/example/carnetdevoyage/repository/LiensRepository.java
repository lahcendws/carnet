package com.example.carnetdevoyage.repository;

import com.example.carnetdevoyage.entity.Liens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiensRepository extends JpaRepository<Liens, Long> {
}
