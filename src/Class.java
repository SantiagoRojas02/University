import java.util.List;

public class Class {
    private String name;
    private String classroom;
    protected List<Student> studentsList;

    public Class(String name, String classroom, List<Student> studentsList) {
        this.name = name;
        this.classroom = classroom;
        this.studentsList = studentsList;
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
}
