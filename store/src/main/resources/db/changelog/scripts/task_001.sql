--liquibase formatted sql
--changeset dyachkov_s:create_table_catalog

create table if not exists store.catalog
(
    id   bigserial
        constraint catalog_pk
            primary key,
    description varchar,
    price  int,
    articul int,
    count int,
    rating int
);

create unique index if not exists catalog_articul_uindex
    on store.catalog (articul);

--changeset dyachkov_s:insert_values_catalog

INSERT into store.catalog(description, price, articul, count, rating)
VALUES ('�������3000', 1500, 001, 100, 10),
('�������', 3100, 002, 55, 8),
('�����������', 2000, 003, 43, 5),
('Thomas made in gemany', 5000, 004, 10, 3),
('LetsSinger', 1000, 005, 50, 10),
('��������', 500, 006, 5, 6),
('����������', 4000, 007, 6, 9),
('����������', 8000, 008, 9, 6),
('VR_������', 36000, 009, 1, 10),
('Mac_������', 1500000, 010, 1, 10)on conflict do nothing;







