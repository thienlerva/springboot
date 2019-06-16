package BalanceBracket;

import java.util.Scanner;
import java.util.Stack;

public class Balance {

    public static void main(String[] args) {

        System.out.println("Enter input: ");
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equalsIgnoreCase("Q")) {
            System.out.println(isValid(input));
            System.out.println("ENter input: ");
            input = scan.nextLine();

        }
    }

    static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        Character openBrace;

        for (Character c : charArray) {
            if (!c.equals('}') && !c.equals(')') && !c.equals(']')) {
                stack.push(c);
            } else {
                openBrace = stack.pop();
                if (!isClosing(openBrace, c)) {
                    return false;
                }
            }
        }

        return stack.size() == 0;

    }

    static boolean isClosing(Character a, Character b) {
        return (a == '{' && b == '}') || (a == '(' && b == ')') || (a == '[' && b == ']');
    }
}
