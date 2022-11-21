package tasks;

import java.util.Stack;

//Napisać program, który zamienia liczbę dzisiętną na binarną.
public class Task2 {
    public static String convertTo(int number) {
        Stack<Integer> stos = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        while (number != 0) {
            stos.push(number % 2);
            number = number / 2;
        }
        while (!stos.empty()) {
            sb.append(stos.pop());
        }
        return sb.toString();
    }
}
