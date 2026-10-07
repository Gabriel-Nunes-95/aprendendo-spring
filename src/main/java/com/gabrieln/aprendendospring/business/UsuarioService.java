package com.gabrieln.aprendendospring.business;

import com.gabrieln.aprendendospring.infrastructure.entities.Usuario;
import com.gabrieln.aprendendospring.infrastructure.exceptions.ConflictException;
import com.gabrieln.aprendendospring.infrastructure.exceptions.ResourceNotFoundException;
import com.gabrieln.aprendendospring.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //Required inicializa somente os campos que possuem o 'final' declarado
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvaUsuario(Usuario usuario){
        try {
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado  " + e.getCause());
        }

    }

    public void emailExiste(String email){
        try {
            boolean existe = verificaEmailExistente(email);
            if(existe){
                throw new ConflictException("E-mail já cadastrado " + email);
            }
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado " + e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("E-mail não encontrado " + email));
    }

    public void deletarUsuarioPorEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }
}
