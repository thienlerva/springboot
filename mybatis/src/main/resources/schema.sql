create table student (
    id int not null primary key,
    name varchar(255) not null,
    phone int,
    email varchar(255)

--    instructorId integer foreign key references instructor(id)
);