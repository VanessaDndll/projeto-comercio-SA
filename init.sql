CREATE DATABASE comercioSA;
USE comercioSA;

CREATE TABLE cliente (
id int PRIMARY KEY AUTO_INCREMENT, 
nome varchar(100) NOT NULL,
cpf varchar(14) NOT NULL UNIQUE, 
data_nascimento date NOT NULL,
endereco varchar(255)
);

CREATE TABLE contato (
id int PRIMARY KEY AUTO_INCREMENT, 
cliente_id int NOT NULL,
tipo varchar(50) NOT NULL, 
valor varchar(100) NOT NULL, 
observacao varchar(255),
CONSTRAINT FK_clienteConato FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
