package App;

import model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapToInt {

    public static void main(String[] arg) {

        Employee employee1 = new Employee("Anthony", 2, 20.99);
        Employee employee2 = new Employee("Jennifer", 6, 39.99);
        Employee employee3 = new Employee("Thien", 38, 45000.99);

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

        System.out.println(employees.stream().mapToDouble(Employee::getSalary).summaryStatistics());
        employees.stream().mapToDouble(Employee::getSalary).sum();
        employees.stream().filter(e -> e.getSalary()>30).forEach(System.out::println);
        employees.stream().sorted((e1, e2) -> e1.getSalary().intValue() - e2.getSalary().intValue()).forEach(System.out::println);
        employees.stream().sorted((e1, e2) -> e2.getName().compareTo(e1.getName())).forEach(System.out::println);
    }
}
