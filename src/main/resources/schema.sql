create table if not exists users (
    id bigserial primary key,
    nickname varchar(15) not null unique,
    email varchar(30) not null unique,
    fio varchar(50) not null unique
);


create table if not exists streaming_service(
    id bigserial primary key,
    name varchar(15) not null unique,
    url varchar unique,
    description text
);

create table if not exists subscription(
    id bigserial primary key,
    user_id bigint not null references users(id),
    streaming_service_id bigint not null references streaming_service(id),
    licence_key text,
    expiration_date date not null
);
