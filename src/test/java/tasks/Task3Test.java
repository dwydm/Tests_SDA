package tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task3Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/task3.csv")
    void shouldCalculateFactorial(long number, long expected) {
        long actual = Task3.calculateFactorial(number);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(NumberToTask3Provider.class)
    void shouldCalculateFactorialArgumentSource(long number, long expected) {
        long actual = Task3.calculateFactorial(number);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(longs = {34, 89, 67, 100})
    void shouldThrowException(long number){
        assertThrows(IllegalArgumentException.class,
                () -> Task3.calculateFactorial(number), "Number is too large!");
    }
}
