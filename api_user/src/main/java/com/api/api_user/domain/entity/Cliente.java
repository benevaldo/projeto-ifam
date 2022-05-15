package com.api.api_user.domain.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "nome é obrigatório")
    @Length(message = "O campo nome excedeu o limite de 50 caracteres", max = 50)    
    String nome;

    @Column(name = "login")
    @NotBlank(message = "login é obrigatório")
    @Length(message = "O campo login excedeu o limite de 30 caracteres", max = 30)
    String login;

    @Column(name="senha")
    @NotBlank(message = "Senha é obrigatória")
    @Length(message="Senha com no máximo 30 caracteres",max=30)
    String senha;

    @Column(name = "email")
    @Email(message = "Email inválido")
    @Length(message = "O campo email excedeu o limite de 50 caracteres", max = 50)
    @NotNull(message = "Email é obrigatório")
    @NotBlank(message = "Email é obrigatório")
    String email;

    @Column(name="cpf")
    @CPF(message = "cpf inválido")
    @Length(message="Cpf com no máximo 11 caracteres",max=11)
    String cpf;

    @Column(name = "sexo")
    @NotBlank(message = "sexo é obrigatório")
    @Pattern(regexp = "^(?:M|F)$", message = "caractere invalido para sexo")
    @Length(message = "O campo sexo excedeu o limite de 1 caractere, responder com M para masculino e F para feminino", min = 1, max = 1)
    String sexo;

    @Column(name="datanascimento")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone = "EST")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "data nascimento é obrigatório")
    Date datanascimento;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "endereco", referencedColumnName = "id")
    @Valid
    Endereco endereco;

}
