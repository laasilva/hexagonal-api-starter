DROP TABLE IF EXISTS user;

create table hexa_db.tb_user (
     id int auto_increment primary key,
     username varchar (255) not null,
     password varchar (255) not null
);
