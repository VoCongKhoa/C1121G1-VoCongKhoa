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

-- [Thực hành] Thêm dữ liệu vào trong cơ sở dữ liệu quản lý sinh viênAssignment
-- set lại giá trị cho auto_increment
alter table class auto_increment = 1;
insert into class(class_name, start_date, `status`) 
values ('A2', '2008-12-22', 1),
('B3', current_date(), 0);

insert into student(student_name, address, phone, `status`, class_ID)
values ('Hung', 'Ha Noi', '0912113113', 1, 1),
('Hoa', 'Hai Phong', null, 1, 1),
('Manh', 'HCM', 0123123123, 0, 2);

insert into `subject`(subject_name, credit, `status`)
values ('CF',5,1), 
('C',6,1),
('HDJ',5,1),
('RDBMS',10,1);

insert into mark(subject_ID, student_ID, mark, exam_times)
values (1,1,8,1),
(1,2,10,2),
(2,1,12,1);

select mark_ID, subject_ID, student_ID, mark, exam_times from mark;
select subject_ID, subject_name, credit, `status` from `subject`;
select student_ID, student_name, address, phone, `status`, class_ID from student;
select class_ID, class_name, start_date, `status` from class;

-- [Thực hành] Truy vấn dữ liệu với CSDL Quản lý sinh viên
use QuanLySinhVien;
select * from student;
select * from student where `status` = true;
select * from `subject` where credit < 10;
select * from student inner join class on student.class_ID = class.class_ID where class_name = 'A1';
select subject_name, mark from mark inner join `subject` on mark.subject_ID = `subject`.subject_ID where subject_name = 'CF';

-- [Bài tập] Truy vấn dữ liệu với CSDL Quản lý sinh viên
use QuanLySinhVien;
select student_ID, student_name, address, phone, `status`, class_ID from student;
select class_ID, class_name, start_date, `status` from class;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select student_ID, student_name, address, phone, `status`, class_ID from student where student_name like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select class_ID, class_name, start_date, `status` from class where month(start_date) = 12 and `status` = true;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select subject_ID, subject_name, credit, `status` from `subject` where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
set sql_safe_updates = 0;
update student set class_ID = 2 where student_name = 'Hung';
set sql_safe_updates = 1;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select student_name, subject_name, mark 
from mark 
inner join student on mark.student_ID = student.student_ID
inner join `subject` on mark.subject_ID = `subject`.subject_ID
order by mark desc;

