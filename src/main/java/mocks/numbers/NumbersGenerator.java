package mocks.numbers;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class NumbersGenerator {

    public Set<Integer> generateNumbers(String name,int a, int b, int x){
        Set<Integer> result=new TreeSet<>();
        Random random=new Random();
        while (result.size()!=x){
            result.add(random.nextInt(b-a+1)+a);
        }
        return result;
    }
}
