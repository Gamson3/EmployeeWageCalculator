import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    List<Employee> readEmployeeData(String fileName) throws IOException;
    void readWorkHourData(String fileName, ArrayList<Employee> employees) throws IOException;
}
