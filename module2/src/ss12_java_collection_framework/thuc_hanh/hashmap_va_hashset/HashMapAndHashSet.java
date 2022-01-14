package ss12_java_collection_framework.thuc_hanh.hashmap_va_hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapAndHashSet {

    static Map<Integer,Student> studentMap = new HashMap<>();
    static Set<Student> studentSet = new HashSet<>();
    static {
        studentMap.put(1, new Student("Khoa",28, "ĐN", "C1121G1"));
        studentMap.put(2, new Student("Vo",29, "QN", "C1221G1"));
        studentMap.put(3, new Student("Cong",30, "Hue", "C1021G1"));
        studentMap.put(4, new Student("Su",26, "SG", "C0921G1"));
        studentMap.put(5, new Student("Uyen",25, "HN", "C0821G1"));

        studentSet.add(new Student("Khoa",28, "ĐN", "C1121G1"));
        studentSet.add(new Student("Vo",29, "QN", "C1221G1"));
        studentSet.add(new Student("Cong",30, "Hue", "C1021G1"));
        studentSet.add(new Student("Su",26, "SG", "C0921G1"));
        studentSet.add(new Student("Uyen",25, "HN", "C0821G1"));
    }

    public static void main(String[] args) {
//        for (int i = 0; i < studentMap.size(); i++) {
//            System.out.println(studentMap.get(i+1));
//        }

        //Duyệt value
//        for(Student student : studentMap.values()){
//            System.out.println(student.toString());
//        }
        //Duyệt key
//        for(Integer key : studentMap.keySet()){
//            System.out.println(key.toString());
//        }
        //Duyệt key + value
        for(Map.Entry<Integer, Student> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }

        for(Student student : studentSet){
            System.out.println(student.toString());
        }

    }

}
