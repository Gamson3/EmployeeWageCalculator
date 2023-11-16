public abstract class Employee implements Comparable<Employee>  {
    private String identifier;
    private String name;
    private String position;
    private int requiredDailyWorkHours;
    private double basicOrHourlyWage;
    private double overtimeWage;
    private int sumOfWorkHours;
    private int sumOfOvertimeHours;
    private double totalPayment;

    public Employee(String identifier, String name, String position, int requiredDailyWorkHours, double basicOrHourlyWage, double overtimeWage) {
        this.identifier = identifier;
        this.name = name;
        this.position = position;
        this.requiredDailyWorkHours = requiredDailyWorkHours;
        this.basicOrHourlyWage = basicOrHourlyWage;
        this.overtimeWage = overtimeWage;
        this.sumOfWorkHours = 0;
        this.sumOfOvertimeHours = 0;
        this.totalPayment = 0.0;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getRequiredDailyWorkHours() {
        return requiredDailyWorkHours;
    }

    public double getBasicOrHourlyWage() {
        return basicOrHourlyWage;
    }

    public double getOvertimeWage() {
        return overtimeWage;
    }

    public int getSumOfWorkHours() {
        return sumOfWorkHours;
    }

    public int getSumOfOvertimeHours() {
        return sumOfOvertimeHours;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public abstract double calculateWage();

    public void updateWorkHours(int workHours) {
        if (workHours > requiredDailyWorkHours) {
            sumOfWorkHours += requiredDailyWorkHours;
            sumOfOvertimeHours += (workHours - requiredDailyWorkHours);
        } else {
            sumOfWorkHours += workHours;
        }
        totalPayment = calculateWage();
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Wage: $" + totalPayment;
    }
}
