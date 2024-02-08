create table public.person
(
    id      bigserial
        primary key,
    address varchar(255),
    gender  varchar(255),
    name    varchar(255) not null,
    surname varchar(255) not null
);

alter table public.person
    owner to postgres;


