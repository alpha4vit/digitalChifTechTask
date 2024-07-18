-- liquibase formatted sql

--changeset roman_gurinovich:1
create table measurement_type
(
    id bigserial primary key,
    name varchar(20)
);

create table if not exists product_category
(
    id        bigserial primary key,
    parent_id bigint,
    image     varchar(255),
    title     varchar(255)
);

create table if not exists product
(
    id bigserial primary key,
    name varchar(255),
    description varchar(1000),
    applying varchar(1000),
    original_price real,
    measurement_type_id bigint references measurement_type(id),
    units varchar(20),
    product_category_id bigint references product_category(id) on delete cascade
);

create table if not exists product_image
(
    id bigserial primary key,
    image varchar(37),
    product_id bigint references product(id) on delete cascade
);


--changeset roman_gurinovich:2
alter table product add column size varchar(50);
alter table product add column original_currency varchar(20);

--changeset roman_gurinovich:3
insert into product_category(title) values ('ROOT_CATEGORY');

--changeset roman_gurinovich:4
insert into measurement_type(name) values ('ВЕС'), ('ОБЪЕМ');