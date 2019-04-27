create table Customer (
    customer_id number(5),
    customer_name varchar2(50),

);

create table product (
    product_id number(5) primary key,
    product_name varchar2(50),
    product_price number(5,2),
    customer_id number(5)
);