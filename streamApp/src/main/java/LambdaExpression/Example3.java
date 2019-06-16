package LambdaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {

    public static void main(String[] args) {

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Nataraja G", "Accounts", 8000));
        empList.add(new Employee("Nagesh Y", "Admin", 15000));
        empList.add(new Employee("Vasu V", "Security", 2500));
        empList.add(new Employee("Amar", "Entertainment", 8500));

        Example3.sortInLambdaWay(empList);
    }


    static void sortInLambdaWay(List<Employee> employees) {

        Comparator<Employee> employeeComparator =
                (Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary());

        Collections.sort(employees, employeeComparator);

        employees.forEach(employee -> System.out.println(employee.toString()));

        List<Employee> employees1 = employees.stream().sorted((Employee e1, Employee e2) ->
                e1.getSalary().compareTo(e2.getSalary())).collect(Collectors.toList());
        employees1.forEach(employee -> System.out.println(employee.toString()));

        List<Employee> employees2 = employees.stream().sorted(
                Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        employees2.forEach(employee -> System.out.println(employee.toString()));
    }
}


class Employee {

    private String name;
    private String account;
    private Integer salary;

    public Employee() {};

    public Employee(String name, String account, Integer salary) {
        super();
        this.name = name;
        this.account = account;
        this.salary = salary;
    }

    @Override
    public String toString() {

        return "name: "+ this.name +" | account: "+ this.account +" | salary: "+this.salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void increase(int rate) {
        this.salary = salary * rate;
    }
}
