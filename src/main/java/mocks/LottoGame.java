package mocks;

import java.util.Set;

    public class LottoGame {

        private NumbersGenerator numbersGenerator;
        private Set<Integer> set1;
        private Set<Integer> set2;
        private static String PLAYER_ONE = "PLAYER ONE";
        private static String PLAYER_TWO = "PLAYER TWO";

        public LottoGame(NumbersGenerator numbersGenerator) {
            this.numbersGenerator = numbersGenerator;
        }

        public String play() {
            set1 = numbersGenerator.generateNumbers(PLAYER_ONE, 10, 20, 5);
            set2 = numbersGenerator.generateNumbers(PLAYER_TWO,10, 20, 5);
            int result = compareSets(set1, set2);
            if (result<0) {
                return PLAYER_ONE;
            }
            else if (result>0) {
                return PLAYER_TWO;
            }
            return "REMIS";
        }

        private int compareSets(Set<Integer> set1, Set<Integer> set2) {
            int suma1=0;
            int suma2=0;
            for (Integer i:set1) {
                suma1=suma1+i;
            }
            for (Integer j:set2) {
                suma2=suma2+j;
            }
            return suma1-suma2;
        }
    }

