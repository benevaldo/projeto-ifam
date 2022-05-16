package com.api.api_user.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(name = "cep")
    @NotBlank(message = "cep é obrigatório")
    @Length(message = "O campo cep tem que estar no formato: 60130240, sem pontos e traços e com 8 números", min = 8, max = 8)
    String cep;

    @Column(name = "rua")
    @NotBlank(message = "rua é obrigatório")
    @Length(message = "O campo rua tem que ter no mínimo 3 caracteres e no máximo 30 caracteres", min = 3, max = 30)
    String rua;

    @Column(name = "bairro")
    @NotBlank(message = "bairro é obrigatório")
    @Length(message = "O campo bairro tem que ter no mínimo 3 caracteres e no máximo 30 caracteres", min = 3, max = 30)
    String bairro;

    @Column(name = "numero")
    @NotBlank(message = "numero é obrigatório")
    @Length(message = "O campo número tem que ter no mínimo 1 caracteres e no máximo 5 caracteres", min = 1, max = 5)
    String numero;

    @Column(name = "cidade")
    @NotBlank(message = "cidade é obrigatório")
    @Length(message = "O campo cidade tem que ter no mínimo 3 caracteres e no máximo 30 caracteres", min = 3, max = 30)
    String cidade;

    @Column(name = "uf")
    @NotBlank(message = "uf é obrigatório")
    @Pattern(regexp = "([A-Z]+)", message = "Utilize caracteres maiúsculos, exemplo: AM, RJ, SP")
    @Length(message = "O campo uf tem que ter 2 caracteres, exemplo: AM, RJ, SP", min = 2, max = 2)
    String UF;
    
    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

}