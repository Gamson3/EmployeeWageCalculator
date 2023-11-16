import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> readEmployeeData(String fileName) throws IOException {
        // Implementation for reading employee data
        Scanner csvReader = new Scanner(new File(fileName));
        while (csvReader.hasNextLine()) {
            String[] data = csvReader.nextLine().split(";");
            if (data.length == 6) {
                String identifier = data[0];
                String name = data[1];
                String position = data[2];
                int requiredDailyWorkHours = Integer.parseInt(data[3]);
                double basicOrHourlyWage = Double.parseDouble(data[4]);
                double overtimeWage = Double.parseDouble(data[5]);

                if (position.equals("manager")) {
                    Controller.employees.add(new Manager(identifier, name, requiredDailyWorkHours, basicOrHourlyWage, overtimeWage));
                } else if (position.equals("worker")) {
                    Controller.employees.add(new Worker(identifier, name, requiredDailyWorkHours, basicOrHourlyWage, overtimeWage));
                }
            }
        }
        csvReader.close();

        return Controller.employees;
    }

    @Override
    public void readWorkHourData(String fileName, ArrayList<Employee> employees) throws IOException {
        // Implementation for reading work hour data
        Scanner csvReader = new Scanner(new File(fileName));
        while (csvReader.hasNextLine()) {
            String[] data = csvReader.nextLine().split(";");
            if (data.length == 2) {
                String identifier = data[0];
                int workHours = Integer.parseInt(data[1]);

                for (Employee employee : employees) {
                    if (employee.getIdentifier().equals(identifier)) {
                        employee.updateWorkHours(workHours);
                        break;
                    }
                }
            }
        }
        csvReader.close();
    }
}
