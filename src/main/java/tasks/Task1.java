package tasks;

//Napisać program sprawdzajacy czy liczba jest pierwsza.
public class Task1 {
    public static boolean isPrime(int number) {
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
