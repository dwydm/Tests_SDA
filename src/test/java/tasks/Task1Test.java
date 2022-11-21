package tasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    @ParameterizedTest(name = "1) Testing number {0} is prime.")
    @ValueSource(ints = {1, 5})
    void shouldBePrime(int number) {
        boolean actual = Task1.isPrime(number);
        assertEquals(true, actual);

    }

    @ParameterizedTest(name = "2) Testing by method if {0} is prime.")
    @MethodSource("numberProvider")
    void shouldBePrimeByMethodSource(int number) {
        boolean actual = Task1.isPrime(number);
        assertEquals(true, actual);

    }

    static Stream<Integer> numberProvider() {
        return Stream.of(1, 7, 3);
    }


    @ParameterizedTest(name = "2) Testing by method if {0} is not prime.")
    @MethodSource("numberProvider2")
    void shouldNotBePrimeByMethodSource(int number) {
        boolean actual = Task1.isPrime(number);
        assertEquals(false, actual);

    }

    static Stream<Integer> numberProvider2() {
        return Stream.of(10, 24, 36);
    }
}