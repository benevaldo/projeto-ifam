package com.api.api_user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    long id;
    String cpf; 
    String nome;
    String sexo; 
    String nascimento;
}
