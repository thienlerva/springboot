package LambdaExpression;

import java.util.Arrays;
import java.util.List;

public class Example1 {

    public static void main(String[] args) {
        FuncInterface fobj = (int x) -> System.out.println(2 * x);

        fobj.normalFun();
        fobj.abstractFun(5);


        List<Integer> integerList = Arrays.asList(1,2,3,4);

        integerList.forEach(n -> System.out.println(n));

        integerList.forEach(n -> { if (n % 2 == 0) System.out.println(n);});
    }
}

@FunctionalInterface
interface FuncInterface {
    // An abstract function
    void abstractFun(int x);

    //normal funciton default function
    default void normalFun() {
        System.out.println("Heelo");
    }
}
