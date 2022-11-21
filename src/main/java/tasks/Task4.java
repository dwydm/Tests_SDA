package tasks;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

//Napisać program, który losuje x róznych liczb z przedziału <a,b>
// gdzie wszystkie trzy liczby są liczbami całkowitymi dodatnimi
public class Task4 {
    public static Set<Integer> losuj(int a, int b, int x) {
        Random random = new Random();
        Set<Integer> result = new TreeSet<>();
        while (result.size() != x) {
            result.add(random.nextInt(b - a + 1) + a);
        }
        return result;
    }
}
