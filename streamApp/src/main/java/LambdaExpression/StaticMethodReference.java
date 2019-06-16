package LambdaExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaticMethodReference {

    public static void main(String a[]) {

        List<String> countryList = new ArrayList<>();
        countryList.add("India");
        countryList.add("USA");
        countryList.add("Japan");
        countryList.add("Canada");

        // print the list elements in normal way
        System.out.println("<--- Prior to java-8 --->");
        for(String str:countryList) {
            StaticMethodReference.printString(str);
        }

        // In Method Reference way
        System.out.println("\n<--- java-8 method reference way --->");
        countryList.forEach(StaticMethodReference::printString);

        // in Lambda expression way
        System.out.println("\n<--- java-8 lambda expression way --->\n");
        countryList.forEach(str -> StaticMethodReference.printString(str));

        // toUpperCase is static method reference
        countryList.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void printString(String str) {
        System.out.println(str);
    }
}
