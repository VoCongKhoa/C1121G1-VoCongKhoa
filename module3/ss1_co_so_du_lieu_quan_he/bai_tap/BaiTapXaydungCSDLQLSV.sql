create database student_management char set = utf8 collate = utf8_unicode_520_ci;

create table Student(
`id` int(10) not null primary key auto_increment,
`name` varchar(255) null,
`age` int null,
`country` varchar(255) null
) engine = innoDB;

create table Class(
`id` int(10) not null primary key auto_increment,
`name` varchar(255) null
);

create table Teacher(
`id` int(10) not null primary key auto_increment,
`name` varchar(255) null,
`age` int,
`country` varchar(255)
);

select * from Student;

select * from Class;

select * from Teacher;