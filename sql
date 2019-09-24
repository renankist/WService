--base de dados
CREATE DATABASE ws;

 -- tabelas
CREATE TABLE cliente (
	id serial, 
	nome varchar(80),
	email varchar(80),
	celular varchar(45),
	idade int, 
	PRIMARY KEY(id));

CREATE TABLE produto (
	id serial, 
	descricao varchar(80),
	valor decimal(11,2),
	quantidade_estoque int, 
	PRIMARY KEY(id));
--inserts 

--clientes
INSERT INTO cliente(nome, email,celular, idade ) VALUES ('Juca Bala', 'juca@bala.com', '123123123',46);
INSERT INTO cliente(nome, email,celular, idade ) VALUES ('Bala Juca', 'bala@juca.com', '223123123',26);
INSERT INTO cliente(nome, email,celular, idade ) VALUES ('João Paulo', 'joao@paulo.com', '323123123',16);

--produtos
INSERT INTO produto(descricao, valor,quantidade_estoque ) VALUES ('Mesa',500, 26);
INSERT INTO produto(descricao, valor,quantidade_estoque ) VALUES ('Cadeira',200, 66);
INSERT INTO produto(descricao, valor,quantidade_estoque ) VALUES ('Banco',410, 33);