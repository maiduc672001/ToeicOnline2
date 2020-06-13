  use toeiconline2 ;
  create table user(
  userid bigint not null primary key auto_increment,
  password varchar(255),
  name varchar(255) null,
  fullname varchar(255) null,
  createddate timestamp null
  );
  create table role(
  roleid bigint not null primary key auto_increment,
  name varchar(255),
password varchar(255)
  )