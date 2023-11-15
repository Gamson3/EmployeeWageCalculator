public class Manager extends Employee {
    private double basicWage;

    public Manager(String identifier, String name, int requiredDailyWorkHours, double basicWage, double overtimeWage) {
        super(identifier, name, "manager", requiredDailyWorkHours, basicWage, overtimeWage);
        this.basicWage = basicWage;
    }

    @Override
    public double calculateWage() {
        return basicWage + (getSumOfOvertimeHours() * getOvertimeWage());
    }
}
