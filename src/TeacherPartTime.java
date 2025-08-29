public class TeacherPartTime extends Teacher{
    private int hoursWeek;

    public TeacherPartTime(String name, float baseSalary, int hoursWeek) {
        super(name, baseSalary);
        this.hoursWeek = hoursWeek;
    }

    public float calculateSalary() {
        float baseSalary = getBaseSalary();
        baseSalary *= hoursWeek;
        return baseSalary;
    }

    public int getHoursWeek() {
        return hoursWeek;
    }

    public void setHoursWeek(int hoursWeek) {
        this.hoursWeek = hoursWeek;
    }
}