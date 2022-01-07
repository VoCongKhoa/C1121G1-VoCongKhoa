package demo.student_manager;

public class Teacher extends Person {
    private String subject;
    private int classGrade;

    public Teacher() {
    }

    public Teacher(String subject, int classGrade) {
        this.subject = subject;
        this.classGrade = classGrade;
    }

    public Teacher(int id, String name, String dateOfBirth, int age, String address, String subject, int classGrade) {
        super(id, name, dateOfBirth, age, address);
        this.subject = subject;
        this.classGrade = classGrade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(int classGrade) {
        this.classGrade = classGrade;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", classGrade='" + classGrade + '\'' +
                '}';
    }

    public void teach(String subject){
        System.out.println("Teach " + subject);
    }

    public int isGrade(){
        return this.classGrade;
    }

    public void moveBy(String vehicle){
        System.out.println("Move by" + vehicle);
    }
}
