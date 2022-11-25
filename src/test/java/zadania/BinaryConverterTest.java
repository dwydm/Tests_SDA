package zadania;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BinaryConverterTest {

    @ParameterizedTest(name = "is {0} converted to binary")
    @MethodSource("dataProvider")
    void shouldConvertToBinary(int decimal, String expected){
        String result = BinaryConverter.convertDecimalToBinary(decimal);
        assertThat(expected).isEqualTo(result);
    }


    static Stream<Arguments> dataProvider() {
        return Stream.of(Arguments.of(8,"1000"),
                Arguments.of(5, "101"));
    }

}
