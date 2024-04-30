CREATE TABLE IF NOT EXISTS tb_files
(
    id                     bigint generated by default as identity,
    creation_date          timestamp,
    update_date            timestamp,
    uuid                   varchar(255),
    offer_id               bigint,
    bucket                 varchar(255),
    file_key                    varchar(255),
    location               varchar(500),
    status                 varchar(255),
    body                   varchar(255),
    primary key (id)
);

ALTER TABLE IF EXISTS tb_files
    ADD CONSTRAINT IF NOT EXISTS FK_tb_file_tb_offer foreign key (offer_id) references tb_offer(id);
