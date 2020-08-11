create table customer
(
    id    bigint auto_increment primary key,
    email varchar(255) null,
    name  varchar(255) null
);

create table product
(
    id     bigint auto_increment primary key,
    name   varchar(255) null,
    amount double       not null
);

create table sale
(
    id          bigint auto_increment primary key,
    date        datetime     null,
    qty         int          null,
    status      varchar(255) null,
    customer_id bigint       null,
    product_id  bigint       null,
    constraint FK_PRODUCT foreign key (product_id) references product (id),
    constraint FK_SALE foreign key (customer_id) references customer (id)
);

