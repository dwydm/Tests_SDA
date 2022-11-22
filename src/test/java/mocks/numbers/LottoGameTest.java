package mocks.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LottoGameTest {

    @Mock
    NumbersGenerator numbersGenerator;

    @InjectMocks
    LottoGame lottoGame;

    @Test
    void shouldPlayerWin() {
        //given
        String player1Name = "PLAYER ONE";
        String player2Name = "PLAYER TWO";
        //when
        when(numbersGenerator.generateNumbers(player1Name, 10, 20, 5)).thenReturn(Set.of(12, 15, 16, 18, 20));
        when(numbersGenerator.generateNumbers(player2Name, 10, 20, 5)).thenReturn(Set.of(10, 15, 16, 19, 20));
        String actual = lottoGame.play();
        //then
        assertThat(actual).isEqualTo(player2Name);
    }
}