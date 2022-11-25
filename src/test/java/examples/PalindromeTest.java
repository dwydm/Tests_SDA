package examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {
    @ParameterizedTest(name = "Test case for {0}")
    @ValueSource(strings = {"ala", "radar", "kajak"})
    void isPalindrome(String s) {
        boolean expected = true;
        boolean actual = Palindrom.isPalindrome(s);
        assertEquals(expected, actual); //junit
        assertThat(actual).isTrue(); //assertJ
    }

    @ParameterizedTest(name = "Test case for {0}")
    @ValueSource(strings = {"ekran", "rower", "komputer"})
    void notPalindrome(String s) {
        boolean expected = false;
        boolean actual = Palindrom.isPalindrome(s);
        assertEquals(expected, actual); //junit
        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isFalse(); //assertJ
    }

    //@MethodSource
    @ParameterizedTest(name = "Test case for {0}")
    @MethodSource("textProvider")
    void checkIfPalindrome(String s) {
        boolean actual = Palindrom.isPalindrome(s);
        assertEquals(true, actual); //junit
        assertThat(actual).isTrue(); //assertJ

    }

    static Stream<String> textProvider() {
        return Stream.of("ala", "radar", "kajak");
    }



}
