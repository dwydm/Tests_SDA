package zadania;

public class PrimeNumber {

    public static boolean isNumberPrime(int number) {
        int counter = 0;
        for (int i = 1; i <= number ; i++) {
            if(number%i == 0) {
                counter++;
            }
            if (counter > 2) {
                break;
            }
        }
        if(counter == 2) {
            return true;
        } else {
            return false;
        }
    }
}
