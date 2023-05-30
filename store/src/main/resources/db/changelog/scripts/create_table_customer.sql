--liquibase formatted sql
--changeset moshkov_d:create_customer

create table if not exists store.customer
(
    id   bigserial
        constraint customer_pk
            primary key,
    name varchar,
    age  int,
    login varchar
);

create unique index if not exists customer_login_uindex
    on store.customer (login);
