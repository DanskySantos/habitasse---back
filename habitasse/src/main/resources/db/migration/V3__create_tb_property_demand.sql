create table if not exists tb_property_demand
(
    id                              bigint generated by default as identity,
    creation_date                   timestamp,
    update_date                     timestamp,
    uuid                            varchar(255),
    contract_type                   varchar(255),
    property_type                    varchar(255),
    bedrooms_number                 varchar(255),
    furnished                       boolean default false,
    pet_friendly                    boolean default false,
    suggested_value_for_rent        varchar(255),
    suggested_value_for_sale        varchar(255),
    suggested_value_for_seasonal    varchar(255),
    demand_id                       bigint,
    address_id                      bigint,
    user_id                         bigint,
    primary key (id)
);

create table if not exists tb_demand
(
    id                      bigint generated by default as identity,
    creation_date           timestamp,
    update_date             timestamp,
    uuid                    varchar(255),
    property_demand_id      bigint,
    annotation              varchar(255),
    contact                 varchar(255),
    primary key (id)
);

alter table if exists tb_demand
    add constraint if not exists UK_86cal5mg9j0t8j9yn28n9iurt unique (uuid);
alter table if exists tb_demand
    add constraint if not exists FK349pmtlc4ukgn1so04k2ls4kk foreign key (property_demand_id) references tb_property_demand;

alter table if exists tb_property_demand
    add constraint if not exists UK_86cal5mg9j0t8j9yn28n9iuss unique (uuid);
alter table if exists tb_property_demand
    add constraint if not exists FK349pmtlc4ukgn1so04k2ls4kk foreign key (demand_id) references tb_demand;
alter table if exists tb_property_demand
    add constraint if not exists FK349pmtlc4ukgn1so04k2ls4kl foreign key (address_id) references tb_address;
alter table if exists tb_property_demand
    add constraint if not exists FK349pmtlc4ukgn1so04k2ls4pp foreign key (user_id) references tb_user;
