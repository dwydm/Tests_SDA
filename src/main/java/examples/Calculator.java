package examples;

public class Calculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("You can not divide by zero!");
        }
        return a / b;
    }
}
