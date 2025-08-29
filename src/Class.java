import java.util.List;
import java.util.ArrayList;

public class Class {
    private String name;
    private String classroom;
    protected List<Student> studentsList;
    private Teacher teacher;

    public Class(String name, String classroom, List<Student> studentsList, Teacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.studentsList = studentsList;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public void addStudent(Student student) {
        if (student != null) {
            studentsList.add(student);
        }
    }

    public void removeStudent(Student student) {
        studentsList.remove(student);
    }


}
