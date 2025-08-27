public class TeacherPartTime extends Teacher{
    private int hoursWeek;

    public TeacherPartTime(String name, float baseSalary) {
        super(name, baseSalary);
    }

    public float calculateSalary() {
        float baseSalary = getBaseSalary();
        baseSalary *= hoursWeek;
        return baseSalary;
    }
}