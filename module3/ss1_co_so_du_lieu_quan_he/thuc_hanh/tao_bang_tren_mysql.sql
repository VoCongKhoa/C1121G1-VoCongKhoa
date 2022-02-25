create database student_management;
use student_management;
create table Student(
`id` int(10) not null primary key auto_increment,
`name` varchar(255) null,
`age` int null,
`country` varchar(255) null
);
