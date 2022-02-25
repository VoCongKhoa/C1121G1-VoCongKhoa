
use student_management;

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