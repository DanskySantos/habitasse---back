create table if not exists tb_usuarios
(
    id               bigint generated by default as identity,
    data_atualizacao timestamp,
    data_criacao     timestamp,
    uuid             varchar(255),
    username         varchar(255),
    password         varchar(255),
    email            varchar(255),
    primary key (id)
);
