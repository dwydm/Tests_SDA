package examples;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromTest {

    // @ValueSource
    @ParameterizedTest(name = "Testing for {0}")
    @ValueSource(strings = {"ALA", "AGA", "KAJAK"})
    void checkIfPalindrome(String text) {
        boolean expected = true;
        boolean actual = Palindrom.isPalindrome(text);
        assertEquals(expected, actual); //junit5
        assertThat(actual).isEqualTo(expected); //assertJ
        assertThat(actual).isTrue();
    }

    // @ValueSource
    @ParameterizedTest(name = "Testing for {0}")
    @ValueSource(strings = {"KOMPUTER", "EKRAN"})
    void checkIfNotPalindrome(String text) {
        boolean expected = false;
        boolean actual = Palindrom.isPalindrome(text);
        assertEquals(expected, actual); //junit5
        assertThat(actual).isEqualTo(expected); //assertJ
        assertThat(actual).isFalse();
    }

    // @MethodSource
    @ParameterizedTest(name = "Testing for {0}")
    @MethodSource("textProvider")
    void checkIfPalindrome2(String input) {
        boolean actual = Palindrom.isPalindrome(input);
        assertEquals(true, actual); //junit5
        assertThat(actual).isTrue(); //assertJ
    }

    private static Stream<String> textProvider() {
        return Stream.of("ALA", "AGA", "KAJAK");
    }
}