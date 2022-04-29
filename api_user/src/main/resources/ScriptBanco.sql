-- Apagar o banco de dados
drop database banco;
-- Criar o banco de dados
create database banco;
-- Atribuir os privilégios de acesso aos objetos do banco
-- para o usuário root
GRANT ALL PRIVILEGES ON banco.* TO 'root' @'localhost';
-- Acesar o banco de dados: banco
USE banco;
-- Criar a tabela: usuario
CREATE TABLE usuario(
    id int AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    login varchar(20) NOT NULL,
    senha varchar(20) NOT NULL,
    email varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cliente(
    id int AUTO_INCREMENT,
    cpf varchar(50) NOT NULL,
    nome varchar(50) NOT NULL,
    sexo varchar(2) NOT NULL,
    nascimento varchar(10) NOT NULL,
    PRIMARY KEY (id)
);

REPAIR TABLE mysql.db
