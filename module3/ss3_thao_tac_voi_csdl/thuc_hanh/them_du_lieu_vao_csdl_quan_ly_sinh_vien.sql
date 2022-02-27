use quan_ly_sinh_vien;

-- [Thực hành] Thêm dữ liệu vào trong cơ sở dữ liệu quản lý sinh viên
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