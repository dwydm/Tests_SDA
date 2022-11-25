package zadania;

public class BinaryConverter {


    public static String convertDecimalToBinary(int decimal) {
        StringBuilder sb = new StringBuilder();
        while(decimal>0){
            if(decimal%2 == 0) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            decimal = decimal/2;
        }

        return sb.reverse().toString();
    }
}
