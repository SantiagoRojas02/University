public class TeacherFullTime extends Teacher{
    private int xpYears;

    public TeacherFullTime(String name, float baseSalary) {
        super(name, baseSalary);
    }

    public float calculateSalary() {
        float baseSalary = getBaseSalary();
        baseSalary *= 1.1f * xpYears;
        return baseSalary;
    }
}
