import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class CompanyRoster {
    static class Department {
        private String depName;
        private List<Employee> employeeList;
        private double avgSalary;

        public Department(String depName, List<Employee> employeeList) {
            this.depName = depName;
            this.employeeList = employeeList;
            this.avgSalary = employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        }

        public String getDepName() {
            return depName;
        }

        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public double getAvgSalary() {
            return avgSalary;
        }

        @Override
        public String toString() {
            return String.format("Highest Average Salary: %s", this.depName);
        }
    }

    static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;

        private String email;
        private int age;

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email = "n/a";
            int age = -1;
            if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            } else if(input.length > 5) {
                email = input[4];
                age = Integer.parseInt(input[5]);
            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            employeeList.add(employee);
        }

        List<String> departmentNames = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        List<Department> departments = departmentNames.stream()
                .map(department -> new Department(department, employeeList.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())))
                .sorted(Comparator.comparingDouble(Department::getAvgSalary).reversed())
                .collect(Collectors.toList());

        Department department = departments.get(0);
        department.getEmployeeList()
                .sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println(department.toString());
        for (Employee employee : department.getEmployeeList()) {
            System.out.println(employee.toString());
        }
    }
}
