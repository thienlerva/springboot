package LambdaExpression;

import java.util.function.BinaryOperator;

interface FuncInter1 {
    int operation(int a,int b);
}

interface FuncInter2 {
    void sayMessage(String message);
}

public class Example2 {

    private int operate(int a, int b, FuncInter1 fobj) {
        return fobj.operation(a,b);
    }

    public static int calculate(int a, int b, BinaryOperator<Integer> bo) {
        return bo.apply(a, b);
    }


    public static void main(String[] args) {

        FuncInter1 add = (x, y) -> x + y;
        FuncInter1 multiply = (int x, int y) -> x*y;

        Example2 tobj = new Example2();

        System.out.println("Addition is " + tobj.operate(6, 3, add));

        System.out.println("Multificaiotn is " + tobj.operate(6, 3, multiply));

        FuncInter2 fobj = message -> System.out.println("Hello" + message);

        fobj.sayMessage("Geek");

        int i = 10;
        int j = 5;

//        int sum = calculate(i, j, (i, j) -> { return (i+j);} );
//        System.out.println("Sum: " + sum);
//
//        int sub = calculate(i, j, (i, j) -> { return (i-j);} );
//        System.out.println("Sub " + sub);

    }
}
