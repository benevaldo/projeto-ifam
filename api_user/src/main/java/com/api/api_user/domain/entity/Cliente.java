package com.api.api_user.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank(message = "CPF é obrigatório")
    @Column(name="cpf")
    @Length(message="CPF com no máximo 11 caracteres",max=11)
    @CPF(message="CPF inválido")
    String cpf; 

    @Column(name="nome")
    @NotBlank(message = "Nome é obrigatório")
    @Length(message="Nome com no máximo 50 caracteres",max=50)
    String nome;

    @Column(name="sexo")
    @NotBlank(message = "Sexo é obrigatório")
    @Length(message="Sexo com no máximo 1 caracteres",max=1)
    String sexo;
    
    @Column(name="nascimento")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    Date nascimento;
}
