create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class(
class_ID int not null primary key auto_increment,
class_name varchar(60) not null,
start_date datetime not null,
`status` bit
);

create table student(
student_ID int not null primary key auto_increment,
student_name varchar(30),
address varchar(50),
phone varchar(20),
`status` bit,
class_ID int not null,
foreign key (class_ID) references class(class_ID)
);

create table `subject`(
subject_ID int not null primary key auto_increment,
subject_name varchar(30) not null,
credit tinyint not null default 1 check (credit >=1),
`status` bit default 1
);

create table mark(
mark_ID int not null primary key auto_increment,
subject_ID int not null,
student_ID int not null,
unique(subject_ID,student_ID),
mark float default 1 check(mark between 0 and 100),
exam_times tinyint default 1,
foreign key(subject_ID) references `subject`(subject_ID),
foreign key(student_ID) references student(student_ID)
);