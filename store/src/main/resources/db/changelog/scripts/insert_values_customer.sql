--liquibase formatted sql
--changeset moshkov_d:create_customer

INSERT into store.customer(name, age, login)
VALUES ('Иван', 23, 'Ivan'),
       ('Олег', 26, 'Oleg') on conflict do nothing;