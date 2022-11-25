package zadania;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNaturalNumbersTest {

    @ParameterizedTest(name = "draw {2} numbers from range between {0} and {1}")
    @CsvSource({"2,4,3","4,12,7"})
    void shouldDrawNumberFromRange(int bottomRangeNumber, int topRangeNumber, int numbersToDraw){
        Set<Integer> actual = RandomNaturalNumbers.drawNaturalNumbers(bottomRangeNumber,topRangeNumber,numbersToDraw);
        assertThat(actual).filteredOn(number -> number >= bottomRangeNumber && number <= topRangeNumber).hasSize(numbersToDraw);
    }


}
