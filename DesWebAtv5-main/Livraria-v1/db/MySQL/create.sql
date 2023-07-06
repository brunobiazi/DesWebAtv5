drop database if exists LocacaoBicicletas;

create database LocacaoBicicletas;

use LocacaoBicicletas;

create table Locadora(id bigint not null auto_increment, email varchar (256) not null, senha varchar (256) not null, cnpj varchar(18) not null, nome varchar(256) not null, cidade varchar(256), primary key (id));

create table Cliente(id bigint not null auto_increment, email varchar(256) not null, senha varchar(256) not null, cpf varchar(16) not null, nome varchar(256) not null, telefone varchar(16) not null, sexo varchar(1) not null, data_nascimento varchar(16) not null, primary key (id));
-- , editora_id bigint not null, primary key (id), foreign key (editora_id) references Editora(id)

insert into Locadora(email, senha, cnpj, nome, cidade) values  ('editora1@gmail.com', 'senha1','11.111.111/1111-11', 'Editora 1', 'São Carlos');

insert into Locadora(email, senha, cnpj, nome, cidade) values  ('editora2@gmail.com', 'senha2','22.222.222/2222-22', 'Editora 2', 'Ribeirão Preto');

insert into Locadora(email, senha, cnpj, nome, cidade) values  ('editora3@gmail.com', 'senha3','33.333.333/3333-33', 'Editora 3', 'Rio Claro');

insert into Locadora(email, senha, cnpj, nome, cidade) values  ('editora3@gmail.com', 'senha3','33.333.333/3333-33', 'Editora 3', 'Araras');

insert into Cliente(email, senha, cpf, nome, telefone, sexo, data_nascimento) values ('cliente1@gmail.com', 'senha1', '111.111.111-11', 'Cliente 1', '(11) 1111-1111', 'M', '2000-01-01');

insert into Cliente(email, senha, cpf, nome, telefone, sexo, data_nascimento) values ('cliente2@gmail.com', 'senha2', '222.222.222-22', 'Cliente 2', '(22) 2222-2222', 'M', '2000-02-02');

insert into Cliente(email, senha, cpf, nome, telefone, sexo, data_nascimento) values ('cliente3@gmail.com', 'senha3', '333.333.333-33', 'Cliente 3', '(33) 3333-3333', 'M', '2000-03-03');

insert into Cliente(email, senha, cpf, nome, telefone, sexo, data_nascimento) values ('cliente4@gmail.com', 'senha4', '444.444.444-44', 'Cliente 4', '(44) 4444-4444', 'M', '2000-04-04');

insert into Cliente(email, senha, cpf, nome, telefone, sexo, data_nascimento) values ('cliente5@gmail.com', 'senha5', '555.555.555-55', 'Cliente 5', '(55) 5555-5555', 'M', '2000-05-05');
quit
