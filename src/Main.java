public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new EmployeeServiceImpl()); // Creating an instance of Controller
        controller.process(args); // Calling the process method on the Controller instance
    }
}
