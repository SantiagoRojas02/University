public class TeacherFullTime extends Teacher{
    private int xpYears;

    public TeacherFullTime(String name, float baseSalary, int xpYears) {
        super(name, baseSalary);
        this.xpYears = xpYears;
    }

    public float calculateSalary() {
        float baseSalary = getBaseSalary();
        baseSalary *= 1.1f * xpYears;
        return baseSalary;
    }

    public int getXpYears() {
        return xpYears;
    }

    public void setXpYears(int xpYears) {
        this.xpYears = xpYears;
    }
}
