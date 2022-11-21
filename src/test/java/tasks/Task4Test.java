package tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @ParameterizedTest
    @CsvSource({"1,4,2", "3,13,6"})
    void shouldDrawNumbers(int lowerBoundary, int upperBoundary, int amount) {
        Set<Integer> actual = Task4.losuj(lowerBoundary, upperBoundary, amount);
        assertThat(actual).filteredOn(number -> number >= lowerBoundary && number <= upperBoundary).hasSize(amount);
    }

    @ParameterizedTest
    @CsvSource({"2,4,3"})
    void shouldDrawMaxAmountNumbers(int lowerBoundary, int upperBoundary, int amount) {
        Set<Integer> actual = Task4.losuj(lowerBoundary, upperBoundary, amount);
        assertThat(actual).filteredOn(number -> number >= lowerBoundary && number <= upperBoundary).hasSize(amount);
    }
}