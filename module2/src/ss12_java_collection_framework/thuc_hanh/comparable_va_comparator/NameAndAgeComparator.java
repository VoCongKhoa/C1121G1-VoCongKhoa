package ss12_java_collection_framework.thuc_hanh.comparable_va_comparator;

import java.util.Comparator;

public class NameAndAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getName().equals(o2.getName())){
            return o1.getAge()-o2.getAge();
        }else return o1.getName().compareTo(o2.getName());
    }
}
