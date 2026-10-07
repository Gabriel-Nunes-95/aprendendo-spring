package com.gabrieln.aprendendospring.infrastructure.repository;

import com.gabrieln.aprendendospring.infrastructure.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
