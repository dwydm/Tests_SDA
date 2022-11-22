package tasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Task5Test {


    @ParameterizedTest(name = "Karty pierwszego gracza {0}. Karty drugiego gracza {1}")
    @MethodSource("playersProvider")
    void play(List<KartaDoGry> cards1, List<KartaDoGry> cards2, String player1, String player2, String expectedWinner) {
        String actualWinner = Task5.play(player1, player2, cards1, cards2);
        assertThat(actualWinner).isEqualTo(expectedWinner);
    }

    private static Stream<Arguments> playersProvider() {
        return Stream.of(
                Arguments.of(
                        new ArrayList<>(Arrays.asList(
                                new KartaDoGry(Figura.DAMA, Kolor.PIK),
                                new KartaDoGry(Figura.AS, Kolor.KARO)))
                        , new ArrayList<>(Arrays.asList(
                                new KartaDoGry(Figura.DAMA, Kolor.PIK),
                                new KartaDoGry(Figura.KROL, Kolor.KARO))),
                        "Gracz",
                        "Komputer", "Gracz")
        );
    }
}