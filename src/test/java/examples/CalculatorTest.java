package examples;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    // @SingleTest - bez parametrów
    @Test
    @DisplayName("Adding two numbers")
    void shouldAddTwoNumbers() {
        int a = 5;
        int b = 6;
        int expected = 11;
        double actual = Calculator.add(a, b);
        assertThat(actual).isEqualTo(expected); // assertJ
    }

    // @MethodSource - extended
    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")
    @MethodSource("numbersProvider")
    void shouldAddTwoNumbers(double firstNumber, double secondNumber, double expected) {
        double actual = Calculator.add(firstNumber, secondNumber);
        assertThat(actual).isEqualTo(expected); // assertJ
    }

    private static Stream<Arguments> numbersProvider() {
        return Stream.of(
                Arguments.of(5.0, 6.0, 11.0),
                Arguments.of(5, 6, 11),
                Arguments.of(-5.0, -5, -10)
        );
    }

    // @ArgumentSource - elementy pobieramy z klasy
    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")
    @ArgumentsSource(NumbersProvider.class)
    void shouldAddTwoNumbersByArgumentSource(double firstNumber, double secondNumber, double expected) {
        double actual = Calculator.add(firstNumber, secondNumber);
        assertThat(actual).isEqualTo(expected); // assertJ
    }

    // @CsvSource
    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")
    @CsvSource({"5.0,5.0,10.0", "3,3,6"})
    void shouldAddTwoNumbersByCsvSource(double firstNumber, double secondNumber, double expected) {
        double actual = Calculator.add(firstNumber, secondNumber);
        assertThat(actual).isEqualTo(expected); // assertJ
    }

    // @CsvFileSource
    @ParameterizedTest(name = "Checking if {0} + {1} = {2}")
    @CsvFileSource(resources = "/numbers.csv")
    void shouldAddTwoNumbersByCsvFileSource(double firstNumber, double secondNumber, double expected) {
        double actual = Calculator.add(firstNumber, secondNumber);
        assertThat(actual).isEqualTo(expected); // assertJ
    }

    // testowanie wyjątków
    @Test
    @DisplayName("Division by zero")
    void shouldThrowsException() {
        int a = 5;
        int b = 0;
        assertThrows(ArithmeticException.class,
                () -> Calculator.divide(a, b),
                "Division by zero"); //JUnit5

        assertThatThrownBy(() -> Calculator.divide(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("You can not divide by zero!"); //assertJ
    }
}