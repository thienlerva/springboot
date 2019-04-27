package App;

import model.Employee;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MapToInt {

    public static void main(String[] arg) {

        Employee employee1 = new Employee("Anthony", 2, 20.99);
        Employee employee2 = new Employee("Jennifer", 6, 39.99);
        Employee employee3 = new Employee("Thien", 38, 45000.99);
        Employee employee4 = new Employee("Thien", 38, 45000.99);

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4);

        System.out.println(employees.stream().mapToDouble(Employee::getSalary).summaryStatistics());
        employees.stream().mapToDouble(Employee::getSalary).sum();
        employees.stream().filter(e -> e.getSalary()>30).forEach(System.out::println);
        employees.stream().sorted((e1, e2) -> e1.getSalary().intValue() - e2.getSalary().intValue()).forEach(System.out::println);
        employees.stream().sorted((e1, e2) -> e2.getName().compareTo(e1.getName())).forEach(System.out::println);

        List<String> strList = Arrays.asList("1", "2", "3", "4");

        List<Integer> integers = strList.stream()
                .map(Integer::new).collect(Collectors.toList());

        System.out.println(integers);

        int[] nums = new int[] {1,2,3,4,5,6};

        int total = Arrays.stream(nums).sum();

        int[] result = Arrays.stream(nums).filter(n -> n %2 != 0).map(n -> n * 2).toArray();

        System.out.println(Arrays.toString(result));

        List<String> stringList = integers.stream()
                    .map(id -> id.toString()).collect(Collectors.toList());

        System.out.println(stringList);


        List<Employee> employeeList = strList.stream()
                .map(id -> new Employee("An", Integer.valueOf(id), 45.00)).collect(Collectors.toList());

        List<Employee> employeeList1 = strList.stream()
                .map(id ->
                        {Employee employee = new Employee();
                            employee.setAge(new Integer(id));
                            return employee;
                        }).collect(Collectors.toList());

        System.out.println(employeeList);
        System.out.println(employeeList1);
    }
}
