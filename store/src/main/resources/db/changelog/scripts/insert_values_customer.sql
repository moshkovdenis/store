--liquibase formatted sql
--changeset moshkov_d:insert_values_customer

INSERT into store.customer(name, age, login)
VALUES ('Иван', 23, 'Ivan'),
       ('Стас', 29, 'Stas'),
       ('Олег', 26, 'Oleg') on conflict do nothing;