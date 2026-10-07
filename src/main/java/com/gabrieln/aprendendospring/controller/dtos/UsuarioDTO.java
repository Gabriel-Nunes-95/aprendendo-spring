package com.gabrieln.aprendendospring.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//Esta é apenas uma classe de transferência de dados. Expõem ou recebe dados
public class UsuarioDTO {

    private String email;
    private String senha;

}
