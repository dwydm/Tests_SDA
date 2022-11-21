package tasks;

import java.util.ArrayList;
import java.util.List;

//Utworz klasę o nazwie KartaDoGry. Użyj składowych figura i kolor. Zastosuj hermetyzację.
//Napisz komparator, który będzie porównywał karty. Figury ustawione w kolejności rosnącej : W,D,K,A.
//Kolory ustawione w kolejności rosnącej: pik, trefl, karo, kier
//Utwórz klase w której zasymulujesz grę jednego gracza z komputerem w wojnę używając talii kart.
public class Task5 {

    private static final String PLAYER_ONE = "Gracz";
    private static final String PLAYER_TWO = "CPU";
    private static List<KartaDoGry> player1Cards = new ArrayList<>();
    private static List<KartaDoGry> player2Cards = new ArrayList<>();
    private List<KartaDoGry> cards1 = new ArrayList<>();
    private static final KartaDoGry DAMA_KIER = new KartaDoGry(Figura.DAMA, Kolor.KIER);
    private static final KartaDoGry DAMA_PIK = new KartaDoGry(Figura.DAMA, Kolor.PIK);
    private static final KartaDoGry KROL_KIER = new KartaDoGry(Figura.KROL, Kolor.KIER);
    private static final KartaDoGry KROL_KARO = new KartaDoGry(Figura.KROL, Kolor.KARO);
    private static final KartaDoGry WALET_KARO = new KartaDoGry(Figura.WALET, Kolor.KARO);

    public static void showStatus(String player1, String player2, List<KartaDoGry> cards1, List<KartaDoGry> cards2) {
        System.out.println("-------");
        System.out.println("Stan gry");
        System.out.println(player1 + " ma karty " + cards1);
        System.out.println(player2 + " ma karty " + cards2);
        System.out.println("-------");
    }

    public static void prepareCardsForPlayerOne() {
        player1Cards.add(DAMA_KIER);
        player1Cards.add(DAMA_PIK);
        player1Cards.add(KROL_KIER);
    }

    public static void prepareCardsForPlayerTwo() {
        player2Cards.add(KROL_KARO);
        player2Cards.add(WALET_KARO);
    }

    public static String play(String player1, String player2, List<KartaDoGry> cards1, List<KartaDoGry> cards2) {
        showStatus(player1, player2, cards1, cards2);
        while (cards1.size() != 0 && cards2.size() != 0) {
            System.out.println("Bitwa trwa ... ");
            KartaDoGry player1Card = cards1.get(0);
            KartaDoGry player2Card = cards2.get(0);
            System.out.println(player1 + " wyciąga kartę " + player1Card);
            System.out.println(player2 + " wyciąga karte " + player2Card);
            if (player1Card.compareTo(player2Card) < 0) {
                System.out.println("Bitwe wygrywa " + player2);
                cards1.remove(0);
                cards2.remove(0);
                cards2.add(player2Card);
                cards2.add(player1Card);
            } else {
                System.out.println("Bitwe wygrywa " + player1);
                cards2.remove(0);
                cards1.remove(0);
                cards1.add(player1Card);
                cards1.add(player2Card);
            }
            showStatus(player1, player2, cards1, cards2);
        }
        if (player1Cards.size() == 0) {
            return player1;
        } else {
            return player2;
        }
    }

    public static void main(String[] args) {
        prepareCardsForPlayerOne();
        prepareCardsForPlayerTwo();
        String winner = play(PLAYER_ONE, PLAYER_TWO, player1Cards, player2Cards);
        System.out.println("Player " + winner + " wins");
    }
}
