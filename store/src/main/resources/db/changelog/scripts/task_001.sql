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
VALUES ('Шкуродёр3000', 1500, 001, 100, 10),
('Плюмбус', 3100, 002, 55, 8),
('МамкинШокер', 2000, 003, 43, 5),
('Thomas made in gemany', 5000, 004, 10, 3),
('LetsSinger', 1000, 005, 50, 10),
('КозлоПас', 500, 006, 5, 6),
('Теребункул', 4000, 007, 6, 9),
('Телефункен', 8000, 008, 9, 6),
('VR_Дениса', 36000, 009, 1, 10),
('Mac_Дениса', 1500000, 010, 1, 10)on conflict do nothing;







