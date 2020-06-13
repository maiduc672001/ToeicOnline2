use toeiconline2;
create table exerciselisten(
    exerciselistenid bigint not null primary key auto_increment,
    name varchar(255) not null ,
    createddate timestamp ,
    modifieddate timestamp
);
create table listenguideline(
    listenguidelineid bigint not null primary key auto_increment,
    content TEXT not null,
    exerciselistenid BIGINT not null,
        createddate timestamp
);
create table questionlistenexe(
    questionlistenid bigint not null primary key auto_increment,
    name varchar(255) not null ,
    image varchar(255),
    audio varchar(255) not null ,
    question TEXT not null ,
    option1 varchar(300) not null ,
    option2 varchar(300) not null ,
    option3 varchar(300) not null ,
    option4 varchar(300) not null ,
    correctanswer varchar(10) not null ,
    exerciseid BIGINT not null ,
    createddate timestamp,
    modifieddate timestamp
)