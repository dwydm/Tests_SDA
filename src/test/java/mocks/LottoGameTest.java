package mocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LottoGameTest {
    private static String PLAYER_ONE = "PLAYER_ONE";
    private static String PLAYER_TWO = "PLAYER_TWO";
    @Mock
    NumbersGenerator numbersGenerator;

    @InjectMocks
    LottoGame lottoGame;

    @Test
    void shouldDesignatedPlayerWin() {
        when(numbersGenerator.generateNumbers(PLAYER_ONE, 10, 20, 5)).thenReturn(Set.of(12,15,16,18,20));
        when(numbersGenerator.generateNumbers(PLAYER_TWO, 10, 20, 5)).thenReturn(Set.of(10,15,16,18,20));
        String actual = lottoGame.play();

        assertThat(actual).isEqualTo(PLAYER_ONE);
    }
}