public class Worker extends Employee {
    private double hourlyWage;

    public Worker(String identifier, String name, int requiredDailyWorkHours, double hourlyWage, double overtimeWage) {
        super(identifier, name, "worker", requiredDailyWorkHours, hourlyWage, overtimeWage);
        this.hourlyWage = hourlyWage;
    }

    @Override
    public double calculateWage() {
        return (getSumOfWorkHours() * hourlyWage) + (getSumOfOvertimeHours() * (hourlyWage * (1 + getOvertimeWage())));
    }
}
