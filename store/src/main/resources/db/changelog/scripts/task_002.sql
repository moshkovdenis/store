--liquibase formatted sql
--changeset dyachkov_s:create_table_basket

create table store.basket
(
    id          bigserial
        constraint basket_pk
            primary key,
    customer_id bigint
        constraint basket_customer_id_fk
            references store.customer,
    catalog_id  bigint
        constraint basket_catalog_id_fk
            references store.catalog
);





