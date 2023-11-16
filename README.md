# EmployeeWagesCalculator

## Overview

This Employee Management System is designed to manage and calculate wages for both managers and workers based on their positions, work hours, and specific wage structures. The system reads employee data from a catalog file and daily work hours from one or more data files. It then performs calculations to determine wages, overtime, and missed hours for each employee.

## Features

### 1. Reading Employee Data

The system reads employee data from a catalog file with the following structure:

```
identifier; name; position; required workhours; basic or hourly wage (based on position); overtime wage
```

- **identifier:** Unique identifier for each employee.
- **name:** Employee's name.
- **position:** Manager or worker.
- **required workhours:** Daily required work hours for the employee.
- **basic or hourly wage:** For managers, it represents the monthly basic wage; for workers, it represents the hourly wage.
- **overtime wage:** Overtime wage, either in hourly amount (for managers) or as a percentage (for workers).

### 2. Reading Daily Work Hours

The system reads daily work hours from one or more data files with the following structure:

```
identifier; workhours worked on a day
```

If the worked hours in a data row exceed the daily required work hours, the system registers overtime hours.

### 3. Printing Current Wages

The system prints the current wages of employees in alphabetical order of employee names. The wage calculation depends on the employee's position:

- For Managers: Wage = basic + (overtime * overtime wage)
- For Workers: Wage = (basic work hours * hourly wage) + (overtime hours * hourly wage * (1 + overtime wage))

### 4. Printing List of Employees by Missed Hours

The system prints a list of employees in order of missed hours, with those who missed the most hours at the front.

### 5. Printing Total Company Payment

The system prints the total amount the company has to pay for normal wage, overtime wage, and the loss resulting from hours employees did not work. This is calculated from the basic wage for managers and the combination of basic work hours and overtime for workers.


## Example

Suppose you have the following files:

- `employees_data.csv` (catalog file)
- `daily_work_hours_1.csv` (daily work hours file)

You would input these file paths when prompted. The system would then process the data and provide the requested outputs.


## Contributions

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
