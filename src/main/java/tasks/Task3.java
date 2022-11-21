package tasks;

//Napisać program obliczajacy silnię dodatniej liczby całkowitej.
public class Task3 {
    public static long calculateFactorial(long number) {
        if (number > 20) throw new IllegalArgumentException("Numer is too large!");
        long result = 1;
        for (long i = 2; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
}
