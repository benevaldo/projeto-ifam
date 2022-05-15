-- Apagar o banco de dados
drop database banco;
-- Criar o banco de dados
create database banco;
-- Atribuir os privilégios de acesso aos objetos do banco
-- para o usuário root
GRANT ALL PRIVILEGES ON banco.* TO 'root' @'localhost';
-- Acesar o banco de dados: banco
USE banco;
-- Criar a tabela: cliente
-- Criar a tabela: endereco
USE banco;

CREATE TABLE endereco(
    id int AUTO_INCREMENT,
    cep varchar(8) NOT NULL,
    rua varchar(30) NOT NULL,
    bairro varchar(30) NOT NULL,
    numero varchar(5) NOT NULL,
    cidade varchar(30) NOT NULL,
    uf varchar(2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cliente(
    id int AUTO_INCREMENT,
    cpf varchar(11) NOT NULL,
    nome varchar(50) NOT NULL,
    sexo varchar(1) NOT NULL,
    login varchar(30) NOT NULL,
    senha varchar(30) NOT NULL,
    email varchar(50) NOT NULL,
    dataNascimento DATE NOT NULL,
    endereco int,
    PRIMARY KEY (id),
    FOREIGN KEY (endereco) REFERENCES endereco(id)
);

# docker-compose up && docker-compose rm -fvs