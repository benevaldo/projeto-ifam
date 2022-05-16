package com.api.api_user.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    Long id;
    String nome;
    String login;
    String email;  
    String cpf;
    String sexo;
    Date dataNascimento;
    EnderecoDto endereco; 
}
