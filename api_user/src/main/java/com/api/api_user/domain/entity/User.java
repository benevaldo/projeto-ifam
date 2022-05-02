package com.api.api_user.domain.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="nome")
    @NotBlank(message = "Nome é obrigatório")
    @Length(message="Nome com no máximo 50 caracteres",max=50)
    String nome;
    @Column(name="login")
    @NotBlank(message = "Login é obrigatório")
    @Length(message="Login com no máximo 30 caracteres",max=30)
    String login;
    @Column(name="senha")
    @NotBlank(message = "Senha é obrigatória")
    @Length(message="Senha com no máximo 30 caracteres",max=30)
    String senha;
    @Column(name="email")
    @NotBlank(message = "E-mail é obrigatório")
    @Email(message="Deve ser um endereço de e-mail bem formado")
    @Length(message="E-mail com no máximo 50 caracteres",max=50)
    String email;
}
