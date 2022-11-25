package zadania;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CountFactorialTest {

    @ParameterizedTest(name = "count factorial of {0}")
    @CsvSource({"3,6", "9,362880"})
    void shouldCountFactorialNUmber(long number, long expected) {
        long result = CountFactorial.countFactorial(number);
        assertThat(expected).isEqualTo(result);
    }

}
