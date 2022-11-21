package tasks;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;


class Task2Test
{

    @ParameterizedTest(name = "Testing of convert Integer to binary String")
    @MethodSource("dataProvider")
    void shouldConvertToBinary(int number, String binaryNumber)
    {
        String actual = Task2.convertTo(number);
        assertThat(actual).isEqualTo(binaryNumber);
    }

    private static Stream<Arguments> dataProvider()
    {
        return Stream.of(
                Arguments.of(5, "101"),
                Arguments.of(32, "100000")
        );
    }

    @ParameterizedTest(name = "Testing of convert Integer to binary String")
    @CsvFileSource(resources = "/task2.csv")
    void shouldConvertToBinaryFromCsvFile(int number, String binaryNumber)
    {
        String actual = Task2.convertTo(number);
        assertThat(actual).isEqualTo(binaryNumber);
    }

    @ParameterizedTest(name = "Testing of convert Integer to binary String")
    @CsvSource({"10, 1010", "456, 111001000"})
    void shouldConvertToBinaryFromCsv(int number, String binaryNumber)
    {
        String actual = Task2.convertTo(number);
        assertThat(actual).isEqualTo(binaryNumber);
    }
}