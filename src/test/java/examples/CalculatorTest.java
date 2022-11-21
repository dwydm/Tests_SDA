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

    //pojedyczny test
    @Test
    @DisplayName("Adding two numbers")
    void shouldAddTwoNumbers() {
        int a = 5;
        int b = 6;
        int expected = 11;
        double actual = Calculator.add(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}