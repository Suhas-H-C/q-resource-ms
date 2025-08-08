CREATE SCHEMA IF NOT EXISTS TEST1;
SET SCHEMA TEST1;

create sequence TEST1.STUDENT_SEQ start with 1 increment by 50;
create sequence TEST1.ARTIST_SEQ start with 1 increment by 50;

create table TEST1.ARTIST (
        id BIGINT NOT NULL DEFAULT NEXT VALUE FOR TEST1.ARTIST_SEQ,
        name varchar(225) not null,
        bio varchar(4000),
        age bigint not null,
        primary key (id));

create table TEST1.STUDENT (
        id BIGINT NOT NULL DEFAULT NEXT VALUE FOR TEST1.STUDENT_SEQ,
        name varchar(225) not null,
        standard bigint not null,
        primary key (id));


INSERT INTO TEST1.ARTIST (name, bio, age) VALUES ('John', 'John is a good boy', 26);
INSERT INTO TEST1.ARTIST (name, bio, age) VALUES ('Alexa', 'Alexa is a good girl', 22);
INSERT INTO TEST1.STUDENT (name, standard) VALUES ('Kevin', 2);
INSERT INTO TEST1.STUDENT (name, standard) VALUES ('Peter', 2);
