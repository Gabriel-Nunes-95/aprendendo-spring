package com.gabrieln.aprendendospring.infrastructure.repository;

import com.gabrieln.aprendendospring.infrastructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email); //script do JPA que indica se o email existe ou não no banco de dados

    //O Optional é uma classe do java.util que serve para tratar resultados nulos
    //evitando a exceção nullPointerException
    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}
