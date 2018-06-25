
create database clinica;
use clinica;


create table cliente(
    id int auto_increment,
    nome varchar(60),
    cpf varchar(50),
    rg varchar(60),
    sexo char,
    nascimento date,
    contato varchar(60),
    email varchar(60),
    endereco varchar(60),
    cep varchar(60),
    numero int,
    uf char(2),
    ativo boolean default true,
    primary key(id)
);

create table animal(
    id int auto_increment,
    cliente_id int references cliente(id),
    nome varchar(60),
    raca varchar(60),
    especie varchar(60),
    nascimento date,
    ativo boolean default true,
    primary key (id)
);

create table usuario(
    id int auto_increment,
    user varchar(60) not null,
    senha varchar(60) not null,
    tipoConta varchar(30) not null,
    primeiroAcesso boolean not null default true,
    primary key (id)
);

insert into usuario(user, senha, tipoConta, primeiroAcesso) 
values ('vet', 'vet', 'veterinario', false), 
('adm', 'adm', 'adm', false), 
('sec', 'sec', 'secretaria', false);

create table veterinario(
    id int auto_increment,
    nome varchar(60),
    cpf varchar(50),
    rg varchar(60) not null,
    sexo char not null,
    nascimento date not null,
    contato varchar(60) not null,
    email varchar(60) not null,
    endereco varchar(60) not null,
    cep varchar(60) not null,
    numero int not null,
    uf char(2) not null,
    especializacao varchar(20) not null,
    pis varchar(60) not null,
    turno varchar(60) not null,
    plantao boolean not null,
    atendimento varchar(8) not null,
    cirurgiao boolean not null,
    ativo boolean default true,
    primary key (id)
);


create table consulta(
    id int primary key auto_increment,
    data date not null,
    horario varchar(30),
    diaDaSemana varchar(30),
    cliente int references cliente(id),
    animal int references animal(id),
    veterinario int references veterinario(id),
    observacao text,
    realizado boolean default false    
);

create table exame(
    id int auto_increment primary key,
    tutor varchar(30) references cliente(cpf),
    animal varchar(40) references animal(nome),
    exame varchar(30),
    observacao text
);
