package LambdaExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstanceMethodReference {

    public static void main(String[] args) {

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Nataraja G", "Accounts", 8000));
        empList.add(new Employee("Nagesh Y", "Admin", 15000));
        empList.add(new Employee("Vasu V", "Security", 2500));
        empList.add(new Employee("Amar", "Entertinment", 8500));

        Employee employee = new Employee();

        empList.stream().forEach(e -> e.increase(2));

        empList.stream().forEach(System.out::println);
        empList.stream().forEach(employee1 -> System.out.println(employee1.toString()));
    }
}
