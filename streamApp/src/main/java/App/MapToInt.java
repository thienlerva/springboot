package App;

import com.google.common.collect.Lists;
import model.Employee;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.logging.log4j.util.Strings.isNotEmpty;

public class MapToInt {

    public static void main(String[] arg) {

        Employee employee1 = new Employee("Anthony", 2, 20.99);
        Employee employee2 = new Employee("Jennifer", 6, 39.99);
        Employee employee3 = new Employee("Thien", 38, 45000.99);
        Employee employee4 = new Employee("Nga", 40, 40000.99);

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4);

        System.out.println(employees.stream().mapToDouble(Employee::getSalary).summaryStatistics());
        employees.stream().mapToDouble(Employee::getSalary).sum();
        employees.stream().filter(e -> e.getSalary()>30).forEach(System.out::println);
        employees.stream().sorted((e1, e2) -> e1.getSalary().intValue() - e2.getSalary().intValue()).forEach(System.out::println);
        employees.stream().sorted((e1, e2) -> e2.getName().compareTo(e1.getName())).forEach(System.out::println);

        List<String> strList = Arrays.asList("1", "2", "3", "4");

        List<Integer> integers = strList.stream()
                .map(Integer::new).collect(Collectors.toList());

        List<Integer> integers1 = strList.stream()
                .map(i -> new Integer(i)).collect(Collectors.toList());

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

        Stream.of("VyLe", "AnLe", "Thien", "Na").filter(st -> st.length()>2).map(String::toUpperCase).sorted().forEach(System.out::println);

        List<Integer> integerPartition = Arrays.asList(1,2,3,4,5,6,7,8,9);

        System.out.println(Lists.partition(integerPartition, 3));

        Map<Employee, Integer> employeeIntegerMap = new HashMap<>();

        employeeIntegerMap = employees.stream().filter(e -> e.getAge()>1).collect(
                Collectors.toMap(e -> new Employee(e.getName(), e.getAge(), e.getSalary()), e -> e.getAge()));

        System.out.println(employeeIntegerMap);

        Map<Employee, String> functionMap = employees.stream().collect(
                Collectors.toMap(Function.identity(), Employee::getName));

        System.out.println(functionMap);

        StringUtils.isEmpty(employee1);

        Map<Color, Integer> colorIntegerMap = new HashMap<>();

        colorIntegerMap.put(Color.yellow, 1);
        colorIntegerMap.put(Color.green, 2);
        colorIntegerMap.put(Color.BLACK, 1);

        System.out.println(colorIntegerMap.size());

        for (Map.Entry<Color, Integer> entry : colorIntegerMap.entrySet()) {
            System.out.println("Color: " + entry.getKey() + "\n" + "Value: " + entry.getValue());
        }

        System.out.println(isNotEmpty("Hi") ? "Hi" : "Empty");
    }
}
