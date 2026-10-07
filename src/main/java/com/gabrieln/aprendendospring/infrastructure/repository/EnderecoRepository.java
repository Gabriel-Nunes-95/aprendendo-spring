package com.gabrieln.aprendendospring.infrastructure.repository;

import com.gabrieln.aprendendospring.infrastructure.entities.Endereco;
import com.gabrieln.aprendendospring.infrastructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
