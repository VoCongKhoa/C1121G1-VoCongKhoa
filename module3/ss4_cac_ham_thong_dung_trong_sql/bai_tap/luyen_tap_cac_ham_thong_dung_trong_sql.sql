use quan_ly_sinh_vien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select subject_ID, subject_name, credit from `subject` where credit = (select max(credit) from `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select `subject`.subject_ID, `subject`.subject_name, `subject`.credit, mark.mark 
from `subject`
inner join mark on `subject`.subject_ID = mark.subject_ID
where mark.mark = (select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.student_ID, student.student_name, student.address, student.phone, class.class_name, `subject`.subject_name, avg(mark.mark) as avg_mark
from class
inner join student on class.class_ID = student.class_ID
inner join mark on student.student_ID = mark.student_ID
inner join `subject` on mark.subject_ID = `subject`.subject_ID
group by student.student_ID
order by mark.mark desc;
