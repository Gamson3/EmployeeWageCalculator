import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    static ArrayList<Employee> employees = new ArrayList<>();
    private EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void process(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Controller <employee_data_file> <work_hour_files...>");
            return;
        }

        String employeeDataFile = args[0];
        try {
            employees = (ArrayList<Employee>) employeeService.readEmployeeData(employeeDataFile);

            for (int i = 1; i < args.length; i++) {
                String workHourFile = args[i];
                employeeService.readWorkHourData(workHourFile, employees);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(employees);

        printEmployees(employees);
        printMissedHours(employees);
        printTotalPayment(employees);
    }

    private static void printEmployees(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void printMissedHours(ArrayList<Employee> employees) {
    employees.sort((e1, e2) -> (e2.getSumOfWorkHours() - e2.getRequiredDailyWorkHours()) - (e1.getSumOfWorkHours() - e1.getRequiredDailyWorkHours()));
    System.out.println("\nList of employees in order of missed hours (most in front):");
    for (Employee employee : employees) {
        int missedHours = employee.getSumOfWorkHours() - employee.getRequiredDailyWorkHours();
        System.out.println("Name: " + employee.getName() + ", Missed Hours: " + missedHours);
    }
}

    private static void printTotalPayment(ArrayList<Employee> employees) {
        double totalNormalWage = employees.stream().mapToDouble(Employee::calculateWage).sum();
        double totalOvertimeWage = employees.stream().mapToDouble(e -> e.getSumOfOvertimeHours() * e.getOvertimeWage()).sum();
        double totalLossFromMissedHours = employees.stream()
                .mapToDouble(e -> (e.getRequiredDailyWorkHours() - e.getSumOfWorkHours()) * e.getBasicOrHourlyWage())
                .sum();
        double totalPayment = totalNormalWage + totalOvertimeWage - totalLossFromMissedHours;

        System.out.println("\nTotal Normal Wage: $" + totalNormalWage);
        System.out.println("Total Overtime Wage: $" + totalOvertimeWage);
        System.out.println("Total Loss from Missed Hours: $" + totalLossFromMissedHours);
        System.out.println("Total Payment to Employees: $" + totalPayment);
    }
}
