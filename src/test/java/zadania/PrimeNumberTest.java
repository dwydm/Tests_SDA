package zadania;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrimeNumberTest {

    @ParameterizedTest(name = "Is {0} a prime number")
    @ValueSource(ints = {5,7,2,13,17})
    void shouldBePrime(int number) {
        boolean actual = PrimeNumber.isNumberPrime(number);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "Is {0} not a prime")
    @ValueSource(ints = {1,4,6,10,16,100})
    void shouldNotBePrime(int number) {
        boolean actual = PrimeNumber.isNumberPrime(number);
    }
}
