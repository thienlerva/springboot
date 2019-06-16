package ExpressionEvaluation;

import java.util.Stack;

public class EvaluateString {

    public static void main(String[] arg) {
        System.out.println(EvaluateString.evaluate("(10/0) + (2 * 6)"));
        System.out.println(EvaluateString.evaluate("1 * 2 + 12"));
        System.out.println(EvaluateString.evaluate("1 * ( 2 + 1 )"));
        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 ) / 14"));
    }

    public static int evaluate(String expression)
    {

        expression = expression.replaceAll(" ", "");
        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        int length = expression.length();
        int index = 0;
        Character token;

        while (length > index)
        {

            token = expression.charAt(index);

            // Current token is a number, push it to stack for numbers
            if (Character.isDigit(token))
            {
                StringBuffer stringBuffer = new StringBuffer();

                while(index < length && Character.isDigit(token)) {
                    stringBuffer.append(token);
                    index++;
                    token = index < length ? expression.charAt(index) : null;

                }
                values.push(Integer.parseInt(stringBuffer.toString()));
                continue;
            }

            // Current token is an opening brace, push it to 'ops'
            else if (token == '(')
                ops.push(token);

                // Closing brace encountered, solve entire brace
            else if (token == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (token == '+' || token == '-' ||
                    token == '*' || token == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(token, ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(token);
            }

            index++;
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                return a / b;
                default: throw new IllegalArgumentException("Error");
        }
    }
}
