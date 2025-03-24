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

INSERT INTO cliente (nome, cpf, data_nascimento, endereco) VALUES
("Roberto da Silva", "536.473.849-57", "1994-02-10", "Rua Otto Unger, 565"),
("Ana Maria Oliveira", "436.728.364-70", "1970-06-20", "R. Cel. Souza Franco, 993");

INSERT INTO contato (cliente_id, tipo, valor, observacao) VALUES
(1, "telefone", "11972675385", "Somente ligação"),
(1, "email", "roberto.silva@gmail.com", "Sem observação");
INSERT INTO contato (cliente_id, tipo, valor, observacao) VALUES
(2, "telefone", "11984736374", "Sem observação"),
(2, "email", "amariaoli@gmail.com", "Sem observação");